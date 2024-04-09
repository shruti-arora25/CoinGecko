package com.example.coins.data.source.data.CoinListDTO


import com.google.gson.annotations.SerializedName

data class Roi(
    @SerializedName("currency")
    var currency: String,
    @SerializedName("percentage")
    var percentage: Double,
    @SerializedName("times")
    var times: Double
)