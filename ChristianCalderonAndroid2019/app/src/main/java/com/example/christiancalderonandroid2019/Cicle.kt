package com.example.christiancalderonandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_cicle.*
import kotlin.random.Random

class Cicle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cicle)

        btnRandom.setOnClickListener {
            val randomInteger = (1..12).shuffled().first()
            Log.d("Chris",randomInteger.toString())
            val size = randomInteger
            var arrayNew = IntArray(size)
            for (i in arrayNew){
                Log.d("Chris",randomInteger.toString())
            }
        }
    }
}
