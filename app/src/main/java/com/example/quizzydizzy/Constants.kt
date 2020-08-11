package com.example.quizzydizzy

import com.example.quizzydizzy.questionList.Question

object Constants{
    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,"1+10","11", "ABC"
        )
        questionList.add(question1)

        val question2 = Question(
            2,"1+100","101","ABCD"
        )
        questionList.add(question2)

        val question3 = Question(
            3,"10+10","20","ABCDE"
        )
        questionList.add(question3)

        val question4 = Question(
            4,"111+10","121","ABCDEF"
        )
        questionList.add(question4)

        val question5 = Question(
            5,"111+111","222","ABCDEFG"
        )
        questionList.add(question5)

        val question6 = Question(
            6,"222+111","333","ABCDEFGH"
        )
        questionList.add(question6)

        val question7 = Question(
            7,"222+222","444","ABCEFGHI"
        )
        questionList.add(question7)

        val question8 = Question(
            8,"333+333","666","ABC10"
        )
        questionList.add(question8)

        val question9 = Question(
            9,"444+444","888","ABC11"
        )
        questionList.add(question9)

        val question10 = Question(
            10,"555+222","777","ABC12"
        )
        questionList.add(question10)
        return questionList
    }

}