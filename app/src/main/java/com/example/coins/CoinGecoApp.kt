package com.example.coins

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class CoinGecoApp:Application(){

    override fun onCreate() {
        super.onCreate()
    }
}