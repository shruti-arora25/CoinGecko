package com.example.coins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coins.databinding.ActivityMainBinding
import com.example.coins.presentation.coinList.coinAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var bind:ActivityMainBinding
    private lateinit var coinAdapter:coinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind=ActivityMainBinding.inflate(layoutInflater)

        setContentView(bind.root)

        setUpTheRecyclerView()


        }


    private fun setUpTheRecyclerView(){





    }
}