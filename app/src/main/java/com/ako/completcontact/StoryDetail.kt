package com.ako.completcontact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ako.completcontact.EnglishStory.storylist
import kotlinx.android.synthetic.main.activity_story_detail.*

class StoryDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_detail)
        val key= intent.extras?.get("Keys").toString().toInt()
        storytitle.setText(storylist.stories[key].title)
        storybody.setText(storylist.stories[key].body)
    }
}
