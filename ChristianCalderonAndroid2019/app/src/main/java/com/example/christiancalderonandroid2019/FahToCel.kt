package com.example.christiancalderonandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_fah_to_cel.*

class FahToCel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fah_to_cel)

            btnConverter.setOnClickListener {
                var fahrenheit = (inputFah.text.toString().toDouble()-32.0)*(5.0/9.0)
//                Log.d("Chris",fahText)
//                var fahren = Integer.parseInt(fahText)
//                var cel = (fahren-32)*(5/9)
//                Log.v("Chris",cel.toString())

                showCel.text = "Celsius $fahrenheit"

            }
        }
    }


