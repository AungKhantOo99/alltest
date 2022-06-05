package com.ako.completcontact

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ako.completcontact.EnglishStory.story
import com.ako.completcontact.EnglishStory.storylist
import kotlinx.android.synthetic.main.activity_story.*

class Story : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        supportActionBar?.title ="English Story"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
     val storyAdapter=ArrayAdapter<story>(this,android.R.layout.simple_list_item_1,storylist.stories)
        listview.adapter=storyAdapter
        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"Click${storylist.stories[position].body}",Toast.LENGTH_LONG).show()
            val int= Intent(this,StoryDetail::class.java)
            int.putExtra("Keys",position)
            startActivity(int)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
