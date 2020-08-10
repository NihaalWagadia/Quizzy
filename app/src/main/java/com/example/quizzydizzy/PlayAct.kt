package com.example.quizzydizzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.quizzydizzy.questionList.Question
import kotlinx.android.synthetic.main.activity_play.*

class PlayAct : AppCompatActivity() {


    private var mCurrentPos: Int = 1
    private var mQuestionList: ArrayList<Question>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        mQuestionList = Constants.getQuestions()
        setQuestion()
        val button1 = findViewById<Button>(R.id.one)
        val button2 = findViewById<Button>(R.id.two)
        val button3 = findViewById<Button>(R.id.three)
        val button4 = findViewById<Button>(R.id.four)
        val button5 = findViewById<Button>(R.id.five)
        val button6 = findViewById<Button>(R.id.six)
        val button7 = findViewById<Button>(R.id.seven)
        val button8 = findViewById<Button>(R.id.eight)
        val button9 = findViewById<Button>(R.id.nine)
        val button0 = findViewById<Button>(R.id.zero)
        val enter = findViewById<Button>(R.id.enter)

        button0.setOnClickListener {
            showResult("0", true)
        }
        button1.setOnClickListener {
            showResult("1", true)
        }
        button2.setOnClickListener {
            showResult("2", true)
        }
        button3.setOnClickListener {
            showResult("3", true)
        }
        button4.setOnClickListener {
            showResult("4", true)
        }
        button5.setOnClickListener {
            showResult("5", true)
        }
        button6.setOnClickListener {
            showResult("6", true)
        }
        button7.setOnClickListener {
            showResult("7", true)
        }
        button8.setOnClickListener {
            showResult("8", true)
        }
        button9.setOnClickListener {
            showResult("9", true)
        }
        clear.setOnClickListener {
            answer_input.text = ""
        }
        enter.setOnClickListener {

                val question = mQuestionList?.get(mCurrentPos-1)
                if(question!!.correctAnswer.compareTo(answer_input.text.toString())==0){
                    Toast.makeText(this, "You're right", Toast.LENGTH_SHORT).show()
                    mCurrentPos++
                    answer_input.text = null
                    when {
                        mCurrentPos <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            //Toast.makeText(this, "You're done", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, CompletionActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()
                }

                if(mCurrentPos == mQuestionList!!.size){
                    Log.d("Enter Final Screen", "Congrats Screen")
                }

            }

    }


    fun showResult(string: String, canClear: Boolean) {
        if (canClear) {
            answer_input.append(string)
        }
    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPos - 1]
//        if(mCurrentPos == mQuestionList!!.size){
//            Toast.makeText(this, "Congrats", Toast.LENGTH_SHORT).show()
//        }
        question_image.text = question!!.question

    }
}