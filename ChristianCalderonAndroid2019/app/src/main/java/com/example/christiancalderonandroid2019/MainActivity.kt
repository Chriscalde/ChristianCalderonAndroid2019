package com.example.christiancalderonandroid2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        btnHelloWorld.setOnClickListener {
            val intent = Intent(this, HelloWorld::class.java)
            startActivity(intent)
        }

        btnTimeFighter.setOnClickListener{
            val intent = Intent(this,TimeFighter::class.java)
            startActivity(intent)
        }
        btnConvert.setOnClickListener {
            val intent = Intent(this,FahToCel::class.java)
            startActivity(intent)
        }
        btnShow.setOnClickListener{
            val intent = Intent(this,Dialog::class.java)
            startActivity(intent)
        }
        btnDialogTwo.setOnClickListener{
            val intent = Intent(this,DialogManager::class.java)
            startActivity(intent)
        }
    }


}
