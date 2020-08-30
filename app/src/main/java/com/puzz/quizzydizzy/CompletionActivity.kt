package com.puzz.quizzydizzy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_completion.*

class CompletionActivity : Immersive() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completion)
        congrats.startAnimation(AnimationUtils.loadAnimation(this, R.anim.pulse))


    }

    fun playAgain(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(Constants.SHARED_FILENAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
        startActivity(intent)
        finish()
    }
}