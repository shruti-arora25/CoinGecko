package com.example.coins.domain.use_cases

import com.example.coins.domain.domain_repository.CoinRepo
import com.example.coins.domain.model.Coin
import com.example.coins.domain.model.CoinDetail
import com.example.coins.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository: CoinRepo
) {

    operator fun invoke(id:String): Flow<ResponseState<CoinDetail>> = flow {
        try {
            emit(ResponseState.Loading<CoinDetail>())
            val coinDetail=repository.getCoinById(id).toCoinDetail()


            emit(ResponseState.Success<CoinDetail>(coinDetail))

        }
        catch (e: HttpException){
            emit(ResponseState.Error<CoinDetail>(e.localizedMessage?:"An unexpected Error"))


        }
        catch (e: IOException){
            emit(ResponseState.Error<CoinDetail> ("Error Occured"))

        }
    }
}