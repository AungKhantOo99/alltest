package com.ako.completcontact

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ako.completcontact.Quizz.OptionArray
import kotlinx.android.synthetic.main.activity_quiz.*

class Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        math.setOnClickListener{
            startActivity(Intent(this,AnswerQuiz::class.java))
        }
    }
}
