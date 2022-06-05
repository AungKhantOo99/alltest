package com.ako.completcontact



import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title ="Test App"
        billpayment.setOnLongClickListener {

            Toast.makeText(this,"Click",Toast.LENGTH_LONG).show()
            true
        }

//        billpayment.setOnClickListener {
//            startActivity(Intent(this,Main::class.java))
//        }
        billpayment.setOnClickListener{
            startActivity(Intent(this,Main::class.java))
        }
        story.setOnClickListener {
            startActivity(Intent(this,Story::class.java))
        }
        calculator.setOnClickListener {
            startActivity(Intent(this,Calculator::class.java))
        }
        play_music.setOnClickListener {
            startActivity(Intent(this,PlayMusic::class.java))
        }
        play_video.setOnClickListener {
            startActivity(Intent(this,PlayVideo::class.java))
        }
        quiz.setOnClickListener {
            startActivity(Intent(this,Quiz::class.java))
        }
        note.setOnClickListener {
            startActivity(Intent(this,Note::class.java))
        }
    }
}


