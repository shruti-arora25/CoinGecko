package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class CodeAdditionsDeletions4Weeks(
    @SerializedName("additions")
    var additions: Int,
    @SerializedName("deletions")
    var deletions: Int
)