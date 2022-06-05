package com.ako.completcontact

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    lateinit var note : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        supportActionBar?.setTitle("Calculator")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun clickNumber (view: View){
        val btnclick = view as Button
        var res= result.text.toString()
        when(btnclick.id){
            zero.id-> res+="0"
            one.id-> res+="1"
            two.id-> res+="2"
            three.id-> res+="3"
            four.id-> res+="4"
            five.id-> res+="5"
            six.id-> res+="6"
            seven.id-> res+="7"
            eight.id-> res+="8"
            nine.id-> res+="9"
            ac.id->res=""
            del.id->
            {
                if (res.length>0){
                    res = res.reversed().substring(1)
                    res=res.reversed()
                }else{
                    res=""
                }

            }
            evenodd.id->{
                res = "-" + res
                note="6"
            }
            point.id->res+= "."
            plus.id->
            {
                res+="+"
                note="1"
            }
            minus.id->
            {
                res+="-"
                note="2"
            }
            mult.id->
            {
                res+="*"
                note="3"
            }
            div.id->
            {
                res+="/"
                note="4"
            }
            percent.id->
            {
                res+="%"
                note="5"
            }
            equal.id->
            {
                when(note){
                    "1"->
                    {
                        val ary:List<String> = res.split("+")
                        res = (ary[0].toDouble() + ary[1].toDouble()).toString()
                    }
                    "2"->
                    {
                        val check = res.toCharArray()
                        if (check[0].toString().equals("-")){
                            val finalnum=res.substring(1)
                            val ary:List<String> = finalnum.split("-")
                            res = (ary[0].toDouble() + ary[1].toDouble()).toString()
                            res = "-"+res
                        }else
                        {
                            val ary:List<String> = res.split("-")
                            res = (ary[0].toDouble() - ary[1].toDouble()).toString()
                        }
                    }
                    "3"->
                    {
                        val ary:List<String> = res.split("*")
                        res = (ary[0].toDouble() * ary[1].toDouble()).toString()
                    }
                    "4"->
                    {
                        val ary:List<String> = res.split("/")
                        res = (ary[0].toDouble() / ary[1].toDouble()).toString()
                    }
                    "5"->
                    {
                        val ary:List<String> = res.split("%")
                        res = (ary[0].toDouble() % ary[1].toDouble()).toString()
                    }
                }

            }
        }
        result.setText(res)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
