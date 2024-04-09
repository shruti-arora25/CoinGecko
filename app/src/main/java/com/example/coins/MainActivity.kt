package com.example.coins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.coins.databinding.ActivityMainBinding
import com.example.coins.presentation.coinList.coinAdapter
import com.example.coins.presentation.coinList.coinLiistVM
import com.example.coins.presentation.coins.coinVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var bind:ActivityMainBinding
    private lateinit var coinAdapter:coinAdapter
    private lateinit var LayoutManager:GridLayoutManager
    private var page:Int=0
    private val coinListViewModel:coinLiistVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind=ActivityMainBinding.inflate(layoutInflater)

        setContentView(bind.root)

        setUpTheRecyclerView()
        LayoutManager= GridLayoutManager(this,2)
        bind.recycler.addOnScrollListener(object :RecyclerView.OnScrollListener(){

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (LayoutManager.findLastVisibleItemPosition()==LayoutManager.itemCount-1){
                    page++
                    coinListViewModel.getAllCoins(page.toString())
                    callAPI()
                }
            }


        })


        }

    private fun callAPI() {

        CoroutineScope(Dispatchers.IO).launch {
            coinListViewModel._coinListValue.collectLatest {
                coinListValue->
                when{
                    coinListValue.isLoading->{
                        bind.progressBar.visibility=View.VISIBLE
                    }
                    coinListValue.error.isNotBlank()->{
                        bind.progressBar.visibility=View.GONE
                        Toast.makeText(this@MainActivity,coinListValue.error,Toast.LENGTH_SHORT).show()
                    }
                    coinListValue.coinsList.isNotEmpty()->{

                    }
                }

            }
        }




    }


    private fun setUpTheRecyclerView()
    {

        coinAdapter= coinAdapter(this, ArrayList())
        bind.recycler.adapter=coinAdapter
        bind.recycler.layoutManager=LayoutManager
        bind.recycler.addItemDecoration(
            DividerItemDecoration(bind.recycler.context,(GridLayoutManager(this,1).orientation))
        )




    }
}