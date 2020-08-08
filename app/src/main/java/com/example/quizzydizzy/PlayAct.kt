package com.example.quizzydizzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class PlayAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val questionList = Constants.getQuestions()
        Log.i("Question List Size", "${questionList.size}")
    }
}