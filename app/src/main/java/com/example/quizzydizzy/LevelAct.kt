package com.example.quizzydizzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizzydizzy.questionList.Question
import kotlinx.android.synthetic.main.activity_level.*

class LevelAct : Immersive() {
    private lateinit var mQuestionList: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        mQuestionList = Constants.getQuestions()
        val adapter = AdapterLevel(mQuestionList, this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

    }
    fun goBack(v: View?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
//    override fun onSupportNavigateUp(): Boolean {
//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//        finish()
//        return true
//    }

}