package com.ako.completcontact

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ako.completcontact.Quizz.OptionArray
import kotlinx.android.synthetic.main.activity_answer_quiz.*

class AnswerQuiz : AppCompatActivity() {
    var check = 0
    var size = 0
    var ansOption = ArrayList<OptionArray>()
    var ans = ""
    var correstCount=0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_quiz)
        val ansArray= arrayOf(3,1,2,1,2,3,2,3,2,2)
        ansOption.add(OptionArray("what value is square root of 4", "5", "10", "2", "20"))
        ansOption.add(OptionArray("what value is square root of 81", "9", "10", "15", "20"))
        ansOption.add(OptionArray("what value is square root of 16", "7", "4", "15", "20"))
        ansOption.add(OptionArray("what value is square root of 0.04", "0.2", "0.02", "0.002", "2"))
        ansOption.add(OptionArray("what value is square root of 100", "1", "10", "100", "10000"))
        ansOption.add(OptionArray("what value is cube root of 27", "9", "6", "3", "20"))
        ansOption.add(OptionArray("what value is cube root of 729", "20", "9", "81", "3"))
        ansOption.add(OptionArray("what value is cube root of 8", "3", "4", "2", "6"))
        ansOption.add(
            OptionArray(
                "what value is cube root of 0.000001",
                "0.1",
                "0.01",
                "0.001",
                "0.0001"
            )
        )
        ansOption.add(OptionArray("what value is cube root of 343", "3", "7", "9", "13"))
        que.text = ansOption[size].que
        ansone.text = ansOption[size].opone
        anstwo.text = ansOption[size].optwo
        ansthree.text = ansOption[size].opthree
        ansfour.text = ansOption[size].opfour
        nextpage.setOnClickListener {
            ansone.setBackgroundColor(Color.GRAY)
            anstwo.setBackgroundColor(Color.GRAY)
            ansthree.setBackgroundColor(Color.GRAY)
            ansfour.setBackgroundColor(Color.GRAY)
            size++
            if(size<10){
                que.text=ansOption[size].que
                ansone.text=ansOption[size].opone
                anstwo.text=ansOption[size].optwo
                ansthree.text=ansOption[size].opthree
                ansfour.text=ansOption[size].opfour
                nextpage.visibility=View.GONE
                summit.visibility=View.VISIBLE
            }
            if(size==9){
                nextpage.visibility=View.GONE
                summit.visibility=View.VISIBLE
                summit.setText("Finish")
                nextpage.setText("Show Result")
            }
            if(size==10)
                {
                    nextpage.visibility=View.GONE
                    result_layout.visibility=View.VISIBLE
                    res.text="CONGULATION GUYS YOU CORRECT ${correstCount} QUESTION"
               }
        }
        summit.setOnClickListener {
            if(size<10){
                if(check==ansArray[size]){
                    correstCount++
                }
                setBG()
                when(ansArray[size]){
                    1->ansone.setBackgroundColor(Color.GREEN)
                    2->anstwo.setBackgroundColor(Color.GREEN)
                    3->ansthree.setBackgroundColor(Color.GREEN)
                    4->ansfour.setBackgroundColor(Color.GREEN)
                }
            }
            }
        }
    fun answer(view: View) {
        val btnClick = view as Button
        when (btnClick.id) {
            ansone.id -> {
                ansone.setBackgroundResource(R.drawable.redbg)
                check = 1
            }
            anstwo.id -> {
                anstwo.setBackgroundResource(R.drawable.redbg)
                check = 2
            }
            ansthree.id -> {
                ansthree.setBackgroundResource(R.drawable.redbg)
                check = 3
            }
            ansfour.id -> {
                ansfour.setBackgroundResource(R.drawable.redbg)
                check = 4
            }
        }

    if(check==1 || check==2 || check==3 || check==4)
    {
        ansone.setBackgroundResource(R.drawable.companybg)
        anstwo.setBackgroundResource(R.drawable.companybg)
        ansthree.setBackgroundResource(R.drawable.companybg)
        ansfour.setBackgroundResource(R.drawable.companybg)
        when (btnClick.id) {
            ansone.id -> {
                ansone.setBackgroundResource(R.drawable.redbg)
                check=1
            }
            anstwo.id -> {
                anstwo.setBackgroundResource(R.drawable.redbg)
                check=2
            }
            ansthree.id -> {
                ansthree.setBackgroundResource(R.drawable.redbg)
                check=3
            }
            ansfour.id -> {
                ansfour.setBackgroundResource(R.drawable.redbg)
                check=4
            }
        }
    }}
    fun setBG(){
        when (check) {
            1 -> {
                ansone.setBackgroundColor(Color.RED)
                nextpage.visibility=View.VISIBLE
                summit.visibility=View.GONE
            }
            2 -> {
                summit.visibility=View.GONE
                nextpage.visibility=View.VISIBLE
                anstwo.setBackgroundColor(Color.RED)
            }
            3 -> {
                nextpage.visibility=View.VISIBLE
                summit.visibility=View.GONE
                ansthree.setBackgroundColor(Color.RED)
            }
            4 -> {
                nextpage.visibility=View.VISIBLE
                summit.visibility=View.GONE
                ansfour.setBackgroundColor(Color.RED)
            }
        }
    }
    }


