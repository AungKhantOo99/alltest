package com.ako.completcontact

import android.annotation.SuppressLint
import android.app.Notification
import android.content.Intent
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ako.completcontact.Notes.*
import kotlinx.android.synthetic.main.activity_note.*
var select=ArrayList<Int>()
var check=0
class Note: AppCompatActivity(),SelectItem,ActionMode.Callback{
    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        this.title="Hello"
        floatingActionButton.setOnClickListener {
            val int= Intent(this,writeNote::class.java)
            int.putExtra("Keys",0)
            startActivity(int)
        }
    }
    override fun onStart() {
        super.onStart()
        val db=DataBaseHealper(this)
        val getnote = db.readdata()
        allnotes.layoutManager=LinearLayoutManager(this)
        allnotes.adapter= NotesAdapter(this,getnote,this)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.list-> {
                val db = DataBaseHealper(this)
                val getnote = db.readdata()
                allnotes.layoutManager = GridLayoutManager(this, 2)
                allnotes.adapter = NotesAdapter(this, getnote,this)
                item.setIcon(R.drawable.grid)
                        }

        }
        return super.onOptionsItemSelected(item)
    }
    override fun Select(id: Int) {
          startActionMode(this)
    }
    override fun click(s: Int) {
        Toast.makeText(this,"Select $s",Toast.LENGTH_LONG).show()

    }
    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.deletenote->{
                val handler=DataBaseHealper(this)
                handler.deleteselect(select)
                mode?.finish()
                val db=DataBaseHealper(this)
                val getnote = db.readdata()
                allnotes.layoutManager=LinearLayoutManager(this)
                allnotes.adapter= NotesAdapter(this,getnote,this)
            }
        }
        return true
    }
    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.call,menu)
     return true
    }
    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {

        return true
    }
    override fun onDestroyActionMode(mode: ActionMode?) {

       check=0
    }
}
