package com.example.christiancalderonandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HelloWorld : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        Log.d("Chris","Hola")
    }
}
