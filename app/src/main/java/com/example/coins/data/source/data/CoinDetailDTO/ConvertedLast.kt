package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class ConvertedLast(
    @SerializedName("btc")
    var btc: Double,
    @SerializedName("eth")
    var eth: Double,
    @SerializedName("usd")
    var usd: Int
)