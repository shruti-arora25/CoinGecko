package com.example.coins.di

import com.example.coins.data.repository.CoinRepoImpl
import com.example.coins.data.source.CoinGecoApi
import com.example.coins.domain.domain_repository.CoinRepo
import com.example.coins.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoinGeckoModule {


    @Provides
    @Singleton
    fun provideCoinGeckoApi():CoinGecoApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGecoApi::class.java)

    }



    @Provides
    @Singleton
    fun provideCoinGecko(api: CoinGecoApi):CoinRepo{
        return CoinRepoImpl(api)
    }
}


