package com.example.quizzydizzy.questionList

data class Question(
    val id: Int,
    val question: Int,
    val correctAnswer: String,
    val topicName: String,
    val topicSolution: Int,
    var questionStat: Boolean,
    val challengeNumber:String,
    val lock_image: Int
)