package com.puzz.quizzydizzy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.AudioManager
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.puzz.quizzydizzy.questionList.Question
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
            voice_status.text =getString(R.string.SoundOff)
            1
        } else {
            voice_status.text =getString(R.string.SoundOn)
            0

        }
        object : CountDownTimer(3000, 1000){
            override fun onFinish() {
                voice_status.visibility = View.GONE
            }

            override fun onTick(p0: Long) {
                voice_status.visibility = View.VISIBLE

            }
        }.start()
        savePreference()


    }

    fun clearData(v: View?) {
        object : CountDownTimer(2000, 1000){
            override fun onFinish() {
                restart_status.visibility = View.GONE
            }

            override fun onTick(p0: Long) {
                restart_status.visibility = View.VISIBLE

            }
        }.start()
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(Constants.SHARED_FILENAME, Context.MODE_PRIVATE)
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