package com.example.coins.presentation.coinList

import com.example.coins.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean=false,
    val coinsList: List<Coin> = emptyList(),
    val error:String=""
)
