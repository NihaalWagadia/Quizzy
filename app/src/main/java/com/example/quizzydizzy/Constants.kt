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
            1,R.string.question_1,"25", "ABC", (R.string.number_one),true, "Challenge 1", R.drawable.lock_question
        )
        questionList.add(question1)

        val question2 = Question(
            2, R.string.question_2,"2","ABCD", (R.string.number_two),false,"Challenge 2", R.drawable.lock_question
        )
        questionList.add(question2)

        val question3 = Question(
            3,R.string.question_3,"16","ABCDE", (R.string.number_three),false,"Challenge 3", R.drawable.lock_question
        )
        questionList.add(question3)

        val question4 = Question(
            4,R.string.question_4,"2","ABCDEF", (R.string.number_four),false,"Challenge 4", R.drawable.lock_question
        )
        questionList.add(question4)

        val question5 = Question(
            5,R.string.question_5,"16","ABCDEFG",(R.string.number_five),false,"Challenge 5", R.drawable.lock_question
        )
        questionList.add(question5)

        val question6 = Question(
            6,R.string.question_6,"5","ABCDEFGH", (R.string.number_six),false,"Challenge 6", R.drawable.lock_question
        )
        questionList.add(question6)

        val question7 = Question(
            7,R.string.question_7,"22","ABCEFGHI", (R.string.number_seven),false,"Challenge 7", R.drawable.lock_question
        )
        questionList.add(question7)

        val question8 = Question(
            8,R.string.question_8,"4","ABC10", (R.string.number_eight),false,"Challenge 8", R.drawable.lock_question
        )
        questionList.add(question8)

        val question9 = Question(
            9,R.string.question_9,"0","ABC11", (R.string.number_nine),false,"Challenge 9", R.drawable.lock_question
        )
        questionList.add(question9)

        val question10 = Question(
            10,R.string.question_10,"55","ABC12",(R.string.number_ten),false,"Challenge 10", R.drawable.lock_question
        )
        questionList.add(question10)

        val question11 = Question(
            11,R.string.question_11,"6561","ABC12",(R.string.number_eleven),false,"Challenge 11", R.drawable.lock_question
        )
        questionList.add(question11)

        val question12 = Question(
            12,R.string.question_12,"9","ABC12",(R.string.number_twelfth),false,"Challenge 12", R.drawable.lock_question
        )
        questionList.add(question12)

        val question13 = Question(
            13,R.string.question_13,"8","ABC12",(R.string.number_13),false,"Challenge 13", R.drawable.lock_question
        )
        questionList.add(question13)

        val question14 = Question(
            14,R.string.question_14,"3","ABC12",(R.string.number_14),false,"Challenge 14", R.drawable.lock_question
        )
        questionList.add(question14)

        val question15 = Question(
            15,R.string.question_15,"16","ABC12",(R.string.number_15),false,"Challenge 15", R.drawable.lock_question
        )
        questionList.add(question15)

        val question16 = Question(
            16,R.string.question_16,"94","ABC12",(R.string.number_16),false,"Challenge 16", R.drawable.lock_question
        )
        questionList.add(question16)

        val question17 = Question(
            17,R.string.question_17,"7","ABC12",(R.string.number_17),false,"Challenge 17", R.drawable.lock_question
        )
        questionList.add(question17)

        val question18 = Question(
            18,R.string.question_18,"2","ABC12",(R.string.number_18),false,"Challenge 18", R.drawable.lock_question
        )
        questionList.add(question18)

        val question19 = Question(
            19,R.string.question_19,"26","ABC12",(R.string.number_19),false,"Challenge 19", R.drawable.lock_question
        )
        questionList.add(question19)

        val question20 = Question(
            20,R.string.question_20,"480","ABC12",(R.string.number_20),false,"Challenge 20", R.drawable.lock_question
        )
        questionList.add(question20)

        val question21 = Question(
            21,R.string.question_21,"32","ABC12",(R.string.number_21),false,"Challenge 21", R.drawable.lock_question
        )
        questionList.add(question21)

        val question22 = Question(
            22,R.string.question_22,"3527","ABC12",(R.string.number_22),false,"Challenge 22", R.drawable.lock_question
        )
        questionList.add(question22)

        val question23 = Question(
            23,R.string.question_23,"888","ABC12",(R.string.number_23),false,"Challenge 23", R.drawable.lock_question
        )
        questionList.add(question23)

        val question24 = Question(
            24,R.string.question_24,"57","ABC12",(R.string.number_24),false,"Challenge 24", R.drawable.lock_question
        )
        questionList.add(question24)

        val question25 = Question(
            25,R.string.question_25,"11","ABC12",(R.string.number_25),false,"Challenge 25", R.drawable.lock_question
        )
        questionList.add(question25)


        val question26 = Question(
            26,R.string.question_26,"17","ABC12",(R.string.number_26),false,"Challenge 26", R.drawable.lock_question
        )
        questionList.add(question26)

        val question27 = Question(
            27,R.string.question_27,"607","ABC12",(R.string.number_27),false,"Challenge 27", R.drawable.lock_question
        )
        questionList.add(question27)

        val question28 = Question(
            28,R.string.question_28,"2","ABC12",(R.string.number_28),false,"Challenge 28", R.drawable.lock_question
        )
        questionList.add(question28)

        val question29 = Question(
            29,R.string.question_29,"13","ABC12",(R.string.number_29),false,"Challenge 29", R.drawable.lock_question
        )
        questionList.add(question29)

        val question30 = Question(
            30,R.string.question_30,"971623","ABC12",(R.string.number_30),false,"Challenge 30", R.drawable.lock_question
        )
        questionList.add(question30)

        val question31 = Question(
            31,R.string.question_31,"86","ABC12",(R.string.number_31),false,"Challenge 31", R.drawable.lock_question
        )
        questionList.add(question31)

        val question32 = Question(
            32,R.string.question_32,"16","ABC12",(R.string.number_32),false,"Challenge 32", R.drawable.lock_question
        )
        questionList.add(question32)

        val question33 = Question(
            33,R.string.question_33,"7","ABC12",(R.string.number_33),false,"Challenge 33", R.drawable.lock_question
        )
        questionList.add(question33)

        val question34 = Question(
            34,R.string.question_34,"1","ABC12",(R.string.number_34),false,"Challenge 34", R.drawable.lock_question
        )
        questionList.add(question34)

        val question35 = Question(
            35,R.string.question_35,"12","ABC12",(R.string.number_35),false,"Challenge 35", R.drawable.lock_question
        )
        questionList.add(question35)

        val question36 = Question(
            36,R.string.question_36,"12","ABC12",(R.string.number_36),false,"Challenge 36", R.drawable.lock_question
        )
        questionList.add(question36)

        val question37 = Question(
            37,R.string.question_37,"1","ABC12",(R.string.number_37),false,"Challenge 37", R.drawable.lock_question
        )
        questionList.add(question37)

        val question38 = Question(
            38,R.string.question_38,"21","ABC12",(R.string.number_38),false,"Challenge 38", R.drawable.lock_question
        )
        questionList.add(question38)

        val question39 = Question(
            39,R.string.question_39,"78","ABC12",(R.string.number_39),false,"Challenge 39", R.drawable.lock_question
        )
        questionList.add(question39)

        val question40 = Question(
            40,R.string.question_40,"5","ABC12",(R.string.number_40),false,"Challenge 40", R.drawable.lock_question
        )
        questionList.add(question40)

        val question41 = Question(
            41,R.string.question_41,"30","ABC12",(R.string.number_41),false,"Challenge 41", R.drawable.lock_question
        )
        questionList.add(question41)

        val question42 = Question(
            42,R.string.question_42,"71","ABC12",(R.string.number_42),false,"Challenge 42", R.drawable.lock_question
        )
        questionList.add(question42)

        val question43 = Question(
            43,R.string.question_43,"17","ABC12",(R.string.number_43),false,"Challenge 43", R.drawable.lock_question
        )
        questionList.add(question43)

        val question44 = Question(
            44,R.string.question_44,"1417","ABC12",(R.string.number_44),false,"Challenge 44", R.drawable.lock_question
        )
        questionList.add(question44)

        val question45 = Question(
            45,R.string.question_45,"150","ABC12",(R.string.number_45),false,"Challenge 45", R.drawable.lock_question
        )
        questionList.add(question45)

        val question46 = Question(
            46,R.string.question_46,"11","ABC12",(R.string.number_46),false,"Challenge 46", R.drawable.lock_question
        )
        questionList.add(question46)

        val question47 = Question(
            47,R.string.question_47,"1","ABC12",(R.string.number_47),false,"Challenge 47", R.drawable.lock_question
        )
        questionList.add(question47)

        val question48 = Question(
            48,R.string.question_48,"8","ABC12",(R.string.number_48),false,"Challenge 48", R.drawable.lock_question
        )
        questionList.add(question48)

        val question49 = Question(
            49,R.string.question_49,"34826","ABC12",(R.string.number_49),false,"Challenge 49", R.drawable.lock_question
        )
        questionList.add(question49)

        val question50 = Question(
            50,R.string.question_50,"777","ABC12",(R.string.number_50),false,"Challenge 50", R.drawable.lock_question
        )
        questionList.add(question50)
        return questionList
    }

}