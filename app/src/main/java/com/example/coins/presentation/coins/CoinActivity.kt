package com.example.coins.presentation.coins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.coins.databinding.ActivityCoinBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//@AndroidEntryPoint
class CoinActivity : AppCompatActivity() {
    private lateinit var bind: ActivityCoinBinding
    private val coinViewModel: coinVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(bind.root)

        intent?.let {
            val coinId = it.getStringExtra("id") ?: ""
            if (coinId.isNotBlank()) {
                coinViewModel.getCoinById(coinId.toString())
                observeCoinDetails()
            } else {
                Toast.makeText(
                    this@CoinActivity,
                    "We don't have any id to call",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    private fun observeCoinDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            coinViewModel._coinValue.collectLatest { Value ->
                if (Value.isLoading) {
                    bind.coinPB.visibility = View.VISIBLE
                } else if (Value.error.isNotBlank()) {
                    bind.coinPB.visibility = View.GONE
                    Toast.makeText(this@CoinActivity, Value.error, Toast.LENGTH_SHORT).show()

                } else {
                    bind.coinPB.visibility = View.GONE

                    Value.coinsList?.let { coinDetail ->
                        Picasso.get().load(coinDetail.image).into(bind.imgCoinImageDetail)
                        bind.coinName.text = coinDetail.name
                        bind.coinDesc.text = coinDetail.description
                        bind.coinLowPrice.text = coinDetail.low_price.toString()
                        bind.coinHighPrice.text = coinDetail.high_price.toString()
                        bind.coinPrice.text = coinDetail.price.toString()
                        bind.coinPercentChange.text = coinDetail.price_per_change.toString()


                    }
                }
            }

        }
    }
}

