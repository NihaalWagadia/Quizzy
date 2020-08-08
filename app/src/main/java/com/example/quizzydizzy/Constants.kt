package com.example.quizzydizzy

import com.example.quizzydizzy.questionList.Question

object Constants{
    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,"1+10",11
        )
        questionList.add(question1)

        val question2 = Question(
            1,"1+100",101
        )
        questionList.add(question2)

        val question3 = Question(
            1,"10+10",20
        )
        questionList.add(question3)
        val question4 = Question(
            1,"111+10",121
        )
        questionList.add(question4)

        return questionList
    }

}