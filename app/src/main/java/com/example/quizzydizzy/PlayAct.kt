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
import androidx.appcompat.widget.ViewUtils
import com.example.quizzydizzy.questionList.Question
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_play.*
import java.lang.reflect.Type

class PlayAct : Immersive(), RewardedVideoAdListener {


    private var mCurrentPos: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var counts: String = ""
    internal var mMediaPlayer: MediaPlayer? = null
    var muted: Int = 0
    var mFromLevel: Int = -1
    private lateinit var mRewardedVideoAd: RewardedVideoAd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        MobileAds.initialize(this@PlayAct)
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.rewardedVideoAdListener = this
        loadRewardedVideoAd()

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
                wrong_id.visibility = View.GONE
                if (mCurrentPos != mQuestionList?.size) {
                    mQuestionList?.get(mCurrentPos)?.questionStat = true
                }

                mMediaPlayer = MediaPlayer.create(this, R.raw.right_answer)
                if (muted == 0) {
                    mMediaPlayer?.start()
                }
                savePreference()
                mCurrentPos++
                answer_input.text = null


                when {
                    mCurrentPos <= mQuestionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        mCurrentPos -= 1
                        val intent = Intent(this, CompletionActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            } else {
                wrong_id.visibility = View.VISIBLE
            }

            if (mCurrentPos == mQuestionList!!.size) {
                Log.d("Enter Final Screen", "Congrats Screen")
            }

        }

    }


    private fun loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd(
            "ca-app-pub-3940256099942544/5224354917",
            AdRequest.Builder().build()

        )
    }

    fun answerHint(v: View?) {
        if (mRewardedVideoAd.isLoaded) {
            mRewardedVideoAd.show()
        }

    }

    private fun disableClicks() {
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
        enableClicks()

    }

    private fun enableClicks() {
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
            question_image.text = getString(question!!.question)
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

        var json: String? = DataStore.getProperty(this, Constants.SHARED_FILENAME, "MyObject", "")
        var type = object : TypeToken<ArrayList<Question>>() {}.type
        mQuestionList = Gson().fromJson<ArrayList<Question>>(json, type)
        mQuestionList = mQuestionList ?: (Constants.getQuestions())

        mCurrentPos = if (mFromLevel == -1) {
            DataStore.getProperty(this, Constants.SHARED_FILENAME, Constants.PROPERTY_COUNT, 1)

        } else {
            mFromLevel + 1
        }
        muted = DataStore.getProperty(this, Constants.SHARED_FILENAME, Constants.PROPERTY_MUTED, muted)
        muted = intent.getIntExtra(Constants.PROPERTY_MUTED, muted)

    }

    override fun onRewardedVideoAdClosed() {
        loadRewardedVideoAd()

    }

    override fun onRewardedVideoAdLeftApplication() {
        TODO("Not yet implemented")
    }

    override fun onRewardedVideoAdLoaded() {

    }


    override fun onRewardedVideoAdOpened() {

    }

    override fun onRewardedVideoCompleted() {
        loadRewardedVideoAd()
    }

    override fun onRewarded(p0: RewardItem?) {
        card_for_solution.visibility = View.VISIBLE
        val question = mQuestionList!![mCurrentPos - 1]
        sol.text = getString(question!!.topicSolution)
        disableClicks()
    }

    override fun onRewardedVideoStarted() {

    }

    override fun onRewardedVideoAdFailedToLoad(p0: Int) {
        Toast.makeText(this, "FAILED LOAD", Toast.LENGTH_SHORT).show()
    }

}