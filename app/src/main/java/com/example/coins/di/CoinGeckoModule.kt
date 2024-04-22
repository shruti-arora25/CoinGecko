package com.example.coins.di

import com.example.coins.data.repository.CoinRepoImpl
import com.example.coins.data.source.CoinGecoApi
import com.example.coins.domain.domain_repository.CoinRepo
import com.example.coins.domain.use_cases.CoinListUseCase
import com.example.coins.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*@Module
@InstallIn(SingletonComponent::class)*/
object CoinGeckoModule {


    /* @Provides
     @Singleton*/
    fun provideCoinGeckoApi(): CoinGecoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGecoApi::class.java)

    }

    val getCoinListUseCase = CoinListUseCase()
    val getCoinRepo = CoinRepoImpl()


    /* @Provides
     @Singleton*/
    fun provideCoinGecko(api: CoinGecoApi): CoinRepo {
        return CoinRepoImpl(api)
    }

}


