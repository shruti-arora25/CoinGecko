package com.example.coins.data.repository

import com.example.coins.data.source.CoinGecoApi
import com.example.coins.data.source.data.CoinDetailDTO.CoinDetailDTO
import com.example.coins.data.source.data.CoinListDTO.CoinListDTO
import com.example.coins.di.CoinGeckoModule.provideCoinGeckoApi
import com.example.coins.domain.domain_repository.CoinRepo
import javax.inject.Inject

class CoinRepoImpl /*@Inject constructor*/(
    private val coinApi: CoinGecoApi = provideCoinGeckoApi()
) : CoinRepo {


    override suspend fun getAllCoins(page: String): CoinListDTO {
        return coinApi.getAllCoins(page)
    }

    override suspend fun getCoinById(id: String): CoinDetailDTO {
                return coinApi.getCoinById(id)
    }


}