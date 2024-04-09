package com.example.coins.domain.domain_repository

import com.example.coins.data.source.data.CoinDetailDTO.CoinDetailDTO
import com.example.coins.data.source.data.CoinListDTO.CoinListDTO

interface CoinRepo {

    suspend fun getAllCoins(page:String):CoinListDTO
    suspend fun getCoinById(id:String):CoinDetailDTO


}