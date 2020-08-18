package com.example.quizzydizzy.questionList

data class Question (
    val id: Int,
    val question: String,
    val correctAnswer: String,
    val topicName : String,
    val topicSolution: String
)