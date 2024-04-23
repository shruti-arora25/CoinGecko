package com.example.coins.domain.domain_repository

import com.example.coins.data.source.data.CoinDetailDTO.CoinDetailDTO
import com.example.coins.data.source.data.CoinListDTO.CoinListDTO
import com.example.coins.data.source.data.CoinListDTO.CoinListDTOItem

interface CoinRepo {

    suspend fun getAllCoins(page:String):List<CoinListDTOItem>
    suspend fun getCoinById(id:String):CoinDetailDTO


}