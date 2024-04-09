package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class X(
    @SerializedName("contract_address")
    var contractAddress: String,
    @SerializedName("decimal_place")
    var decimalPlace: Any
)