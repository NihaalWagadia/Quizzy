package com.example.quizzydizzy

import android.app.Activity
import android.app.backup.FileBackupHelper
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import com.example.quizzydizzy.questionList.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_play.*
import java.lang.reflect.Type

class PlayAct : Immersive() {


    private var mCurrentPos: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var counts: String = ""
    internal var mMediaPlayer: MediaPlayer? = null
    var muted: Int = 0
    var mFromLevel: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        mFromLevel = intent.getIntExtra("openLevel", mFromLevel)
        loadPreferences()
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

            val question = mQuestionList?.get(mCurrentPos - 1)
            if (question!!.correctAnswer.compareTo(answer_input.text.toString()) == 0) {
                mQuestionList?.get(mCurrentPos)?.questionStat = true
                savePreference()

                Toast.makeText(this, "You're right", Toast.LENGTH_SHORT).show()

                mCurrentPos++
                answer_input.text = null
                mMediaPlayer = MediaPlayer.create(this, R.raw.right_answer)

                if (muted == 0) {
                    mMediaPlayer?.start()
                }
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
            } else {
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()
            }

            if (mCurrentPos == mQuestionList!!.size) {
                Log.d("Enter Final Screen", "Congrats Screen")
            }

        }

    }

    fun answerHint(v: View?) {
        card_for_solution.visibility = View.VISIBLE
        val question = mQuestionList!![mCurrentPos - 1]
        sol.text = question!!.topicSolution
//        action_bar_relat.visibility = View.INVISIBLE
//        num_pad_view.visibility = View.INVISIBLE
        play_relate.alpha = 0.5f

        one.isClickable = false
        two.isClickable = false
        three.isClickable = false
        four.isClickable = false
        five.isClickable = false
        six.isClickable = false
        seven.isClickable = false
        eight.isClickable = false
        nine.isClickable = false
        zero.isClickable = false
        enter.isClickable = false
        clear.isClickable = false
        go_back.isClickable = false

    }

    fun closeCard(v: View?) {
        card_for_solution.visibility = View.GONE
        play_relate.alpha = 1.0f
        one.isClickable = true
        two.isClickable = true
        three.isClickable = true
        four.isClickable = true
        five.isClickable = true
        six.isClickable = true
        seven.isClickable = true
        eight.isClickable = true
        nine.isClickable = true
        zero.isClickable = true
        enter.isClickable = true
        clear.isClickable = true
        go_back.isClickable = true

    }


    fun goBack(v: View?) {
        val intent = Intent(this, LevelAct::class.java)
        savePreference()
        startActivity(intent)
        finish()
    }


    private fun showResult(string: String, canClear: Boolean) {
        if (canClear) {
            answer_input.append(string)
        }
    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPos - 1]
        if (question.questionStat) {
            question_image.text = question!!.question
            level_number.text = question!!.challengeNumber
            Log.d("Challenge", question!!.challengeNumber)

        }

    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mCurrentPos = (savedInstanceState.getInt("CurrentPosition"))
        muted = (savedInstanceState.getInt(Constants.PROPERTY_MUTED))
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        savePreference()
        startActivity(intent)
        overridePendingTransition(0, 0)
        finish()
        super.onBackPressed()
    }

    private fun savePreference() {
        var sharedPreferences: SharedPreferences =
            getSharedPreferences(Constants.SHARED_FILENAME, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = sharedPreferences.edit()
        var json: String = Gson().toJson(mQuestionList)
        editor.putInt(Constants.PROPERTY_COUNT, mCurrentPos)
        editor.putInt(Constants.PROPERTY_MUTED, muted)
        editor.putString("MyObject", json)
        editor.apply()
    }

    override fun onStop() {
        savePreference()
        super.onStop()
    }

    override fun onDestroy() {
        savePreference()
        super.onDestroy()

    }

    override fun onPause() {
        savePreference()
        super.onPause()
    }

    private fun loadPreferences() {
//        var sharedPreferences: SharedPreferences = getSharedPreferences(Constants.SHARED_FILENAME,Context.MODE_PRIVATE)
//        var json: String? = sharedPreferences.getString("MyObject", null)
        var json: String? = DataStore.getProperty(this, Constants.SHARED_FILENAME, "MyObject", "")

        var type = object : TypeToken<ArrayList<Question>>() {}.type
        mQuestionList = Gson().fromJson<ArrayList<Question>>(json, type)
        mQuestionList = mQuestionList ?: (Constants.getQuestions())


        mCurrentPos = if (mFromLevel == -1) {
//            sharedPreferences.getInt(counts, 1)
            DataStore.getProperty(this, Constants.SHARED_FILENAME, Constants.PROPERTY_COUNT, 1)

        } else {
            mFromLevel + 1
        }
        //mCurrentPos = sharedPreferences.getInt(counts, 1)

//        muted = sharedPreferences.getInt("mutedCond", muted)

        muted =
            DataStore.getProperty(this, Constants.SHARED_FILENAME, Constants.PROPERTY_MUTED, muted)

        muted = intent.getIntExtra(Constants.PROPERTY_MUTED, muted)

    }

}