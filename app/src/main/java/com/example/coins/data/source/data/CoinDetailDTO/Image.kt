package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("large")
    var large: String,
    @SerializedName("small")
    var small: String,
    @SerializedName("thumb")
    var thumb: String
)