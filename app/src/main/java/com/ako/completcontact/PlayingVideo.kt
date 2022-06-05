package com.ako.completcontact

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_playing_video.*

class PlayingVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing_video)
        com.ako.completcontact.VideoPlayer.LoadVideo.Loadvideo(this)
        val values=intent.extras?.get("keys").toString().toInt()
        playingvideo.setVideoURI(Uri.parse(videoList[values].url))
        playingvideo.start()
    }
}
