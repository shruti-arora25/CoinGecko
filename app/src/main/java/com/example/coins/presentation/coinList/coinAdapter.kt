package com.example.coins.presentation.coinList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coins.R
import com.example.coins.databinding.ListItemBinding
import com.example.coins.domain.model.Coin
import com.example.coins.presentation.coins.CoinActivity
import com.squareup.picasso.Picasso

class coinAdapter(private val context: Context, var coinList: ArrayList<Coin>) :
    RecyclerView.Adapter<coinAdapter.CoinVH>(), Filterable {

    lateinit var filteredList: ArrayList<Coin>

    private lateinit var bind: ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): coinAdapter.CoinVH {
        bind = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinVH(bind)
    }

    override fun onBindViewHolder(holder: coinAdapter.CoinVH, position: Int) {

        val coin: Coin = coinList[position]
        holder.coinName.text = coin.name
        holder.coinLayout.setOnClickListener {
            val intent = Intent(context, CoinActivity::class.java)
            intent.putExtra("id", coin.id)
            context.startActivity(intent)
        }

        Picasso.get().load(coin.image).into(holder.coinImg)

    }

    fun setData(list: ArrayList<Coin>) {
        this.filteredList = list
        this.coinList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return coinList.size
    }


    inner class CoinVH(bind: ListItemBinding) : RecyclerView.ViewHolder(bind.root) {
        var coinLayout: LinearLayout = bind.coinLinearLay
        val coinImg: ImageView = bind.imgCoinImage
        val coinName: TextView = bind.txtCoinName
    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val string = constraint?.toString() ?: ""
                if (string.isNotEmpty()) {
                    var arrayList = arrayListOf<Coin>()
                    filteredList.filter {
                        it.name.lowercase().contains(string.lowercase())
                    }.forEach {
                        arrayList.add(it)
                    }
                    filteredList.clear()
                    filteredList.addAll(arrayList)
                } else {
                    filteredList = coinList
                }

                return FilterResults().apply {
                    this.values = filteredList
                }


            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
              if (results?.values==null){
                  ArrayList<Coin>()

              }
                else{

                    setData(filteredList)
              }

            }

        }
    }


}