package com.example.christiancalderonandroid2019

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_time_fighter.*



class TimeFighter : AppCompatActivity() {

    //    lateinit var txtScore: TextView
    var score = 0
    var gameStarted = false
    var initialCountDown: Long = 15000
    var countDownInterval: Long = 1000
    lateinit var countDownTimer: CountDownTimer
    private var startSound: MediaPlayer? = null
    private var endSound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_fighter)



        btnTapMe.setOnClickListener {
            val bounceAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce)
            it.startAnimation(bounceAnimation)
            incrementScore()

        }


    }

    private fun resetGame() {
        score = 0
        txtScore.text

//        val initialTimerLeft: Long = initialCountDown / 1000
        txtTime.text = "Time Left: {60}"
        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft: Long = millisUntilFinished / 1000
                txtTime.text = getString(R.string.your_time, timeLeft.toString())
            }

            override fun onFinish() {
                endGame()
            }
        }
        countDownTimer.start()

        gameStarted = false
    }


    private fun incrementScore() {
        if (!gameStarted) {
            startGame()
        }
        score++
        val newScore = getString(R.string.your_score, score.toString())
        txtScore.text = newScore
    }

    private fun startGame() {
        resetGame()
        gameStarted = true
        startSound = MediaPlayer.create(this,R.raw.game)
        startSound?.start()
    }

    private fun endGame() {
        Toast.makeText(applicationContext,getString(R.string.final_score,score.toString()), Toast.LENGTH_SHORT).show()
        score = 0
        btnTapMe.isClickable = false
        startSound?.stop()
        startSound?.release()
        endSound = MediaPlayer.create(this,R.raw.gameover)
        endSound?.start()

    }

}