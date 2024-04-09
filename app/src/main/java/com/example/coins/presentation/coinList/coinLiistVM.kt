package com.example.coins.presentation.coinList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins.domain.use_cases.CoinListUseCase
import com.example.coins.util.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class coinLiistVM @Inject constructor(private val coinsUseCase: CoinListUseCase):ViewModel() {

    private val coinListValue= MutableStateFlow(CoinListState())
    var _coinListValue:StateFlow<CoinListState> = coinListValue


    fun getAllCoins(page:String)=viewModelScope.launch(Dispatchers.IO) {
        coinsUseCase(page).collect{
            when(it){
                is ResponseState.Success -> {
                coinListValue.value= CoinListState(coinsList = it.data?: emptyList())
                }

            is ResponseState.Loading->{
                coinListValue.value=CoinListState(isLoading = true)
            }

            is ResponseState.Error->{
                coinListValue.value= CoinListState(error= it.message?:"An unexpected Error")
            }

        }

        }

    }

}