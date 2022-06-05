package com.ako.completcontact

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main.*

class Main : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        supportActionBar?.title ="Calculate Bill"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        calculate.setOnClickListener {
            if (price.length()==0 || discount.length()==0 || number.length()==0)
            {
                Toast.makeText(this,"Enter upper Field",Toast.LENGTH_LONG).show()
            }
            else{
                val lastprice = price.text.toString().toFloat() - (price.text.toString().toFloat()/100 * discount.text.toString().toFloat())
                result.setText("Total price is " + lastprice + "$,discount is " + discount.text.toString() + "% and each " +
                        "people should pay " + lastprice / number.text.toString().toFloat()+"$")
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
