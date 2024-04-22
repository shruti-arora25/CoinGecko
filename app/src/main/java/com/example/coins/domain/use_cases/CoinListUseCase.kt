package com.example.coins.domain.use_cases

import android.net.http.HttpException
import com.example.coins.di.CoinGeckoModule.getCoinRepo
import com.example.coins.domain.domain_repository.CoinRepo
import com.example.coins.domain.model.Coin
import com.example.coins.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase /*@Inject constructor*/(
    private val repository:CoinRepo = getCoinRepo
) {

    operator fun invoke(page:String): Flow<ResponseState<List<Coin>>> = flow {
        try {
            emit(ResponseState.Loading<List<Coin>>())
            val coins=repository.getAllCoins(page).map {
                it.toCoin()
            }

            emit(ResponseState.Success<List<Coin>>(coins))

        }
        catch (e:retrofit2.HttpException){
            emit(ResponseState.Error<List<Coin>>(e.localizedMessage?:"An unexpected Error"))


        }
        catch (e:IOException){
            emit(ResponseState.Error<List<Coin>> ("Error Occured"))

        }
    }
}