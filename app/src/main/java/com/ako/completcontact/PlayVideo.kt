package com.ako.completcontact

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ako.completcontact.VideoPlayer.LoadVideo
import com.ako.completcontact.VideoPlayer.videoInfo
import kotlinx.android.synthetic.main.activity_play_video.*
import kotlinx.android.synthetic.main.video.view.*
var videoList=ArrayList<videoInfo>()
class PlayVideo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)
        LoadVideo.Loadvideo(this)
        val adapter=VideoAdapter(this,videoList)
        video.adapter=adapter
    }
    inner class VideoAdapter(val context:Context,val videoList:ArrayList<videoInfo>)
        :BaseAdapter(){
        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val VideoView=LayoutInflater.from(context).inflate(R.layout.video,null)
            val eachVideo=this.videoList[position]
            VideoView.videotitle.text=eachVideo.title
            VideoView.videoplay.setOnClickListener {
                val intentone=Intent(context,PlayingVideo::class.java)
                intentone.putExtra("keys",position)
                context.startActivity(intentone)
            }
            return VideoView
        }

        override fun getItem(position: Int): Any {
            return videoList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return videoList.size
        }

    }
}
