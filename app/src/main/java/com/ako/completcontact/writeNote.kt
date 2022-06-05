package com.ako.completcontact

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ako.completcontact.Notes.DataBaseHealper
import kotlinx.android.synthetic.main.activity_write_note.*
import kotlinx.android.synthetic.main.eachnotes.*
import java.text.SimpleDateFormat
import java.util.*

class writeNote : AppCompatActivity() {
    var key:Int=0
    var now:String=""
    var format= SimpleDateFormat("yyyy MM dd hh:mm", Locale.ROOT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_note)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title="Note"
         key = intent.extras?.get("Keys").toString().toInt()
        val dbhandle=DataBaseHealper(this)
        val date= Calendar.getInstance()
        date.get(Calendar.YEAR)
        date.get(Calendar.MONTH)
        date.get(Calendar.DAY_OF_MONTH)
        date.get(Calendar.HOUR)
        date.get(Calendar.MINUTE)
        date.get(Calendar.SECOND)
        now=format.format(date.time)
        currentdate.setText(now)
        if(key!=0){
           note_title.setText(dbhandle.readtitle(key))
            note_body.setText(dbhandle.readbody(key))
            currentdate.setText(dbhandle.readdate(key))
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.savedel_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save->{
                val save=DataBaseHealper(this)
                if(key==0){
                    if(save.savenote(now,note_title.text.toString(),note_body.text.toString())){
                        Toast.makeText(this,"Save Notes",Toast.LENGTH_LONG).show()
                    }
                }else{
                    currentdate.setText(now)
                    save.update(now,key,note_title.text.toString(),note_body.text.toString())
                    Toast.makeText(this,"Update Notes Successful",Toast.LENGTH_LONG).show()
                }

            }
            R.id.delete->{
                if(key==0){

                    note_title.text=null
                    note_body.text=null
                }else{
                    val delete=DataBaseHealper(this)
                    delete.delete(key)
                    Toast.makeText(this,"Delete Successful",Toast.LENGTH_SHORT).show()
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
