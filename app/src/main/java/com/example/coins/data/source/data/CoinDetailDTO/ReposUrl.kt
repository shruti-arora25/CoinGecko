package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class ReposUrl(
    @SerializedName("bitbucket")
    var bitbucket: List<Any>,
    @SerializedName("github")
    var github: List<String>
)