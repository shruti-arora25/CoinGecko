package com.example.coins.presentation.coins

import com.example.coins.domain.model.CoinDetail

data class CoinState(
    val isLoading: Boolean = false,
    val coinsList: CoinDetail?=null,
    val error: String = ""
)
