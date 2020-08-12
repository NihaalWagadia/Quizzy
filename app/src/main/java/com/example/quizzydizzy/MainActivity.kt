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
import kotlinx.android.synthetic.main.activity_main.*
//0 is on
class MainActivity : AppCompatActivity() {
    var mAudioManager: AudioManager? = null
    var muted:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        loadPreferences()
    }

    fun onClicker(v: View?) {
        val intent = Intent(this, PlayAct::class.java)
        intent.putExtra("mutedCond",muted)
        savePreference()
        startActivity(intent)
        Log.d("VALUEE",muted.toString())
        finish()
    }

    fun soundAdjust(v: View?) {
        muted = if(muted==0){
            1
        } else{
            0
        }
        Log.d("MutedVal", muted.toString())
        savePreference()


    }

    private fun savePreference(){
        val sharedPreferences: SharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt("mutedCond", muted)
        Log.d("MutedValsaverr", muted.toString())
        editor.apply()
    }

    private fun loadPreferences(){
        val sharedPreferences: SharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        muted = sharedPreferences.getInt("mutedCond", 0)
        Log.d("MutedValload", muted.toString())


    }
    override fun onStop() {
        savePreference()
        super.onStop()
    }

    override fun onDestroy() {
        savePreference()
        super.onDestroy()

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
        outState.putInt("mutedCond", muted)
        Log.d("MutedValins", muted.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        muted = (savedInstanceState.getInt("mutedCond"))
    }

}