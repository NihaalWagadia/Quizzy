package com.example.quizzydizzy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizzydizzy.questionList.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_level.*

class LevelAct : Immersive() {
    private var mQuestionList: ArrayList<Question>?=null
    private var counts: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        loadPreferences()

        val adapter = mQuestionList?.let { AdapterLevel(it, this) }
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

    }

    fun goBack(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        savePreference()
        startActivity(intent)
        finish()
    }

    private fun savePreference() {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(Constants.SHARED_FILENAME,Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val json:String= Gson().toJson(mQuestionList)
        editor.putString("MyObject", json)
        editor.apply()
    }

    private fun loadPreferences() {
//        val sharedPreferences: SharedPreferences = this.getSharedPreferences(Constants.SHARED_FILENAME,Context.MODE_PRIVATE)
        val json = DataStore.getProperty(this, Constants.SHARED_FILENAME, "MyObject", "")
        val type = object : TypeToken<ArrayList<Question>>(){}.type
        mQuestionList = Gson().fromJson<ArrayList<Question>>(json,type)
        if(mQuestionList==null){
            mQuestionList = Constants.getQuestions()
        }
    }
    override fun onStop() {
        savePreference()
        super.onStop()

    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        savePreference()
        startActivity(intent)
        overridePendingTransition(0, 0)
        finish()
        super.onBackPressed()

    }

    override fun onPause() {
        savePreference()
        super.onPause()

    }

    override fun onStart() {
        loadPreferences()
        super.onStart()
    }
}