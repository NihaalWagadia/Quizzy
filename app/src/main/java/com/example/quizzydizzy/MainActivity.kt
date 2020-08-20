package com.example.quizzydizzy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.quizzydizzy.questionList.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

//0 is on
class MainActivity : Immersive() {
    var mAudioManager: AudioManager? = null
    var muted: Int = 0
    private var mQuestionList: ArrayList<Question>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadPreferences()
    }


    fun onClicker(v: View?) {
        val intent = Intent(this, PlayAct::class.java)
        intent.putExtra(Constants.PROPERTY_MUTED, muted)
        savePreference()
        startActivity(intent)
        finish()
    }

    fun soundAdjust(v: View?) {
        muted = if (muted == 0) {
            1
        } else {
            0
        }
        savePreference()


    }

    fun clearData(v: View?) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("PlayAct", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    private fun savePreference() {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(Constants.SHARED_FILENAME,Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt(Constants.PROPERTY_MUTED, muted)
        editor.apply()

    }

    fun gotoLevel(v: View?) {
        val intent = Intent(this, LevelAct::class.java)
        intent.putExtra(Constants.PROPERTY_MUTED, muted)
        savePreference()
        startActivity(intent)
        finish()
    }

    private fun loadPreferences() {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(Constants.SHARED_FILENAME,Context.MODE_PRIVATE)
        muted = sharedPreferences.getInt(Constants.PROPERTY_MUTED, 0)

    }

    override fun onStop() {
        savePreference()
        super.onStop()

    }

    override fun onBackPressed() {
        
        savePreference()
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Constants.PROPERTY_MUTED, muted)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        muted = (savedInstanceState.getInt(Constants.PROPERTY_MUTED))
    }


}