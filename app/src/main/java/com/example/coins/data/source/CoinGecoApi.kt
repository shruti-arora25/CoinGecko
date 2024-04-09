package com.example.coins.data.source

import com.example.coins.data.source.data.CoinDetailDTO.CoinDetailDTO
import com.example.coins.data.source.data.CoinListDTO.CoinListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGecoApi {


    @GET("/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&sparkline=false")
    suspend fun getAllCoins(@Query("page")page:String): CoinListDTO


    @GET("/api/v3/coins/{id}")
    suspend fun getCoinById(@Path("id")id:String):CoinDetailDTO


}