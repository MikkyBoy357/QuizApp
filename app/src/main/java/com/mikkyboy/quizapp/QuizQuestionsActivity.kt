package com.mikkyboy.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question> = ArrayList<Question>()
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME).toString()

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        var tvOptionOne = findViewById<View>(R.id.tv_option_one) as TextView
        tvOptionOne.setOnClickListener(this)

        var tvOptionTwo = findViewById<View>(R.id.tv_option_two) as TextView
        tvOptionTwo.setOnClickListener(this)

        var tvOptionThree = findViewById<View>(R.id.tv_option_three) as TextView
        tvOptionThree.setOnClickListener(this)

        var tvOptionFour = findViewById<View>(R.id.tv_option_four) as TextView
        tvOptionFour.setOnClickListener(this)

        var btnSubmit = findViewById<View>(R.id.btn_submit) as Button
        btnSubmit.setOnClickListener(this)

    }

    private fun setQuestion() {

        var question: Question = mQuestionsList[mCurrentPosition - 1]

        defaultOptionsView()

        var btnSubmit = findViewById<View>(R.id.btn_submit) as Button
        if (mCurrentPosition == mQuestionsList.size) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }

        var progressBar = findViewById<View>(R.id.progress_bar) as ProgressBar
        progressBar.progress = mCurrentPosition

        var tvProgress = findViewById<View>(R.id.tv_progress) as TextView
        tvProgress.text = "${mCurrentPosition}/${progressBar.max}"

        var tvQuestion = findViewById<View>(R.id.tvQuestionId) as TextView
        tvQuestion.text = question.question

        var ivImage = findViewById<View>(R.id.iv_image) as ImageView
        ivImage.setImageResource(question.image)

        var tvOptionOne = findViewById<View>(R.id.tv_option_one) as TextView
        tvOptionOne.text = question.optionOne

        var tvOptionTwo = findViewById<View>(R.id.tv_option_two) as TextView
        tvOptionTwo.text = question.optionTwo

        var tvOptionThree = findViewById<View>(R.id.tv_option_three) as TextView
        tvOptionThree.text = question.optionThree

        var tvOptionFour = findViewById<View>(R.id.tv_option_four) as TextView
        tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        var tvOptionOne = findViewById<View>(R.id.tv_option_one) as TextView
        options.add(0, tvOptionOne)

        var tvOptionTwo = findViewById<View>(R.id.tv_option_two) as TextView
        options.add(1, tvOptionTwo)

        var tvOptionThree = findViewById<View>(R.id.tv_option_three) as TextView
        options.add(2, tvOptionThree)

        var tvOptionFour = findViewById<View>(R.id.tv_option_four) as TextView
        options.add(3, tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                val tvOptionOne = findViewById<View>(R.id.tv_option_one) as TextView
                selectedOptionsView(tvOptionOne, 1)
            }
            R.id.tv_option_two -> {
                val tvOptionTwo = findViewById<View>(R.id.tv_option_two) as TextView
                selectedOptionsView(tvOptionTwo, 2)
            }
            R.id.tv_option_three -> {
                val tvOptionThree = findViewById<View>(R.id.tv_option_three) as TextView
                selectedOptionsView(tvOptionThree, 3)
            }
            R.id.tv_option_four -> {
                val tvOptionFour = findViewById<View>(R.id.tv_option_four) as TextView
                selectedOptionsView(tvOptionFour, 2)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionsList[mCurrentPosition - 1]

                    if (question.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    var btnSubmit = findViewById<View>(R.id.btn_submit) as Button
                    if (mCurrentPosition == mQuestionsList.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                val tvOptionOne = findViewById<View>(R.id.tv_option_one) as TextView
                tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                val tvOptionTwo = findViewById<View>(R.id.tv_option_two) as TextView
                tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                val tvOptionThree = findViewById<View>(R.id.tv_option_three) as TextView
                tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                val tvOptionFour = findViewById<View>(R.id.tv_option_four) as TextView
                tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }

}