package com.example.coins

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coins.databinding.ActivityMainBinding
import com.example.coins.domain.model.Coin
import com.example.coins.presentation.coinList.coinAdapter
import com.example.coins.presentation.coinList.coinLiistVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
/*@AndroidEntryPoint*/
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var bind: ActivityMainBinding
    private lateinit var coinAdapter: coinAdapter
    private lateinit var LayoutManager: GridLayoutManager
    private var page: Int = 1
    private val tempCoinList = arrayListOf<Coin>()
    private val coinLiistVM:coinLiistVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)

        setContentView(bind.root)
        LayoutManager = GridLayoutManager(this, 2)

        setUpTheRecyclerView()
        //LayoutManager = GridLayoutManager(this, 2)

        bind.btSort.setOnClickListener {
            tempCoinList.sortWith { o1, o2 -> o1.name.compareTo(o2.name) }
            coinAdapter.setData(tempCoinList)

        }
        callAPI()
        bind.recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (LayoutManager.findLastVisibleItemPosition() == LayoutManager.itemCount - 1) {
                    page++
                    coinLiistVM.getAllCoins(page.toString())

                    callAPI()
                }
            }
        })
    }

    private fun callAPI() {

        CoroutineScope(Dispatchers.IO).launch {
            coinLiistVM._coinListValue.collectLatest { coinListValue ->

                withContext(Dispatchers.Main) {
                    if (coinListValue.isLoading) {
                        bind.progressBar.visibility = View.VISIBLE
                    } else {
                        if (coinListValue.error.isNotBlank()) {
                            bind.progressBar.visibility = View.GONE
                            Toast.makeText(
                                this@MainActivity,
                                coinListValue.error,
                                Toast.LENGTH_SHORT
                            )
                                .show()

                        } else {

                            bind.progressBar.visibility = View.GONE
                            tempCoinList.addAll(coinListValue.coinsList)
                            coinAdapter.setData(tempCoinList)
                        }
                    }
                }

            }
        }
    }

    private fun setUpTheRecyclerView() {

        coinAdapter = coinAdapter(this, ArrayList())
        bind.recycler.adapter = coinAdapter
        bind.recycler.layoutManager = LayoutManager
        bind.recycler.addItemDecoration(
            DividerItemDecoration(bind.recycler.context, (GridLayoutManager(this, 1).orientation))
        )
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val search = menu?.findItem(R.id.menuSearch)
        val searchView = search?.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText?.isEmpty()!!) {
            coinAdapter.setData(tempCoinList)
        } else {
            coinAdapter.filter.filter(newText)
        }

        return true
    }
}