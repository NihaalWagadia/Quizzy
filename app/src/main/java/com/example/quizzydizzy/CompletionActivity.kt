package com.example.quizzydizzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CompletionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completion)

    }

    fun playAgain(v: View?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}