package com.example.quizzydizzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizzydizzy.questionList.Question
import kotlinx.android.synthetic.main.activity_level.*

class LevelAct : AppCompatActivity() {
    private lateinit var mQuestionList: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        mQuestionList = Constants.getQuestions()
        val adapter = AdapterLevel(mQuestionList, this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

    }
}