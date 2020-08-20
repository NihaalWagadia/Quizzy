package com.example.quizzydizzy

import com.example.quizzydizzy.questionList.Question

object Constants{
    val SHARED_FILENAME:String = "dataStore"
    val PROPERTY_COUNT="count"
    val PROPERTY_MUTED="muted_cond"
    val PROPERTY_QUESTION="question_object"
    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,"1+10","11", "ABC", "11",true, "Challenge 1", R.drawable.lock_question
        )
        questionList.add(question1)

        val question2 = Question(
            2,"1+100","101","ABCD","101",false,"Challenge 2", R.drawable.lock_question
        )
        questionList.add(question2)

        val question3 = Question(
            3,"10+10","20","ABCDE", "20",false,"Challenge 3", R.drawable.lock_question
        )
        questionList.add(question3)

        val question4 = Question(
            4,"111+10","121","ABCDEF", "121",false,"Challenge 4", R.drawable.lock_question
        )
        questionList.add(question4)

        val question5 = Question(
            5,"111+111","222","ABCDEFG","222",false,"Challenge 5", R.drawable.lock_question
        )
        questionList.add(question5)

        val question6 = Question(
            6,"222+111","333","ABCDEFGH", "333",false,"Challenge 6", R.drawable.lock_question
        )
        questionList.add(question6)

        val question7 = Question(
            7,"222+222","444","ABCEFGHI", "444",false,"Challenge 7", R.drawable.lock_question
        )
        questionList.add(question7)

        val question8 = Question(
            8,"333+333","666","ABC10", "666",false,"Challenge 8", R.drawable.lock_question
        )
        questionList.add(question8)

        val question9 = Question(
            9,"444+444","888","ABC11", "888",false,"Challenge 9", R.drawable.lock_question
        )
        questionList.add(question9)

        val question10 = Question(
            10,"555+222","777","ABC12","777",false,"Challenge 10", R.drawable.lock_question
        )
        questionList.add(question10)
        return questionList
    }

}