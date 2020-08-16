package com.example.quizzydizzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizzydizzy.questionList.Question
import kotlinx.android.synthetic.main.activity_level.*

class LevelAct : AppCompatActivity() {
    private lateinit var mQuestionList: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

//        val actionBar = supportActionBar
//        actionBar!!.title = "WOOFWOOOF"
//        actionBar.setDisplayHomeAsUpEnabled(true)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title="WEEWEWEWE"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)


        mQuestionList = Constants.getQuestions()
        val adapter = AdapterLevel(mQuestionList, this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        return super.onOptionsItemSelected(item)
//    }
}