package com.mikkyboy.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_nigeria,
            "Nigeria",
            "Australia",
            "Armenia",
            "Austria",
            1
        )

        val que2 = Question(
            2,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_argentina,
            "Cyprus",
            "Georgia",
            "Argentina",
            "Norway",
            3
        )

        val que3 = Question(
            3,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_new_zealand,
            "Algeria",
            "Israel",
            "New Zealand",
            "Australia",
            3
        )

        val que4 = Question(
            4,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_belgium,
            "Germany",
            "Belgium",
            "Fiji",
            "Ireland",
            2
        )

        val que5 = Question(
            5,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_australia,
            "Australia",
            "Kuwait",
            "Albania",
            "Iraq",
            1
        )

        val que6 = Question(
            6,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_kuwait,
            "Saudi Arabia",
            "Kuwait",
            "Iran",
            "Syria",
            2
        )

        val que7 = Question(
            7,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_brazil,
            "Portugal",
            "Mexico",
            "Brazil",
            "Peru",
            3
        )

        val que8 = Question(
            8,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_india,
            "India",
            "Ukraine",
            "Belarus",
            "Pakistan",
            1
        )

        val que9 = Question(
            9,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_denmark,
            "England",
            "Greece",
            "Denmark",
            "Sweden",
            3
        )

        val que10 = Question(
            10,
            "What Country does this Flag belong to?",
            R.drawable.ic_flag_germany,
            "Poland",
            "Netherlands",
            "Germany",
            "Russia",
            3
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        return questionsList
    }

}