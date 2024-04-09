package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class Market(
    @SerializedName("has_trading_incentive")
    var hasTradingIncentive: Boolean,
    @SerializedName("identifier")
    var identifier: String,
    @SerializedName("name")
    var name: String
)