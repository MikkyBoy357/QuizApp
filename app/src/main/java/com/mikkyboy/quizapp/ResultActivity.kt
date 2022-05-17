package com.mikkyboy.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        val tvUserName = findViewById<View>(R.id.tv_user_name) as TextView
        tvUserName.text = userName

        val tvTotalScore = findViewById<View>(R.id.tv_score) as TextView
        tvTotalScore.text = "Yours Score is $correctAnswers out of $totalQuestions"

        val btnFinish = findViewById<View>(R.id.btn_finish) as Button
        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}