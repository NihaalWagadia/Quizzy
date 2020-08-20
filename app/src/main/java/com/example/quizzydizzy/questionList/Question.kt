package com.example.quizzydizzy.questionList

import android.media.Image

data class Question (
    val id: Int,
    val question: String,
    val correctAnswer: String,
    val topicName : String,
    val topicSolution: String,
    var questionStat : Boolean,
    val challengeNumber:String,
    val lock_image: Int
)