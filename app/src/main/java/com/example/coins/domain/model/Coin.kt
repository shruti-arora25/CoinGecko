package com.example.coins.domain.model

data class Coin(

    val id:String,
    val name: String,
    val image:String,
    val mareket_cap:Long,
    val price:Double,
    val price_per_change:Double,
    val low_price:Double,
    val high_price:Double

)
