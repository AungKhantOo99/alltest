package com.ako.completcontact

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.ako.completcontact.MusicPlayer.LoadSong
import com.ako.completcontact.MusicPlayer.songInfo
import kotlinx.android.synthetic.main.activity_play_music.*
import kotlinx.android.synthetic.main.song.*
import kotlinx.android.synthetic.main.song.view.*
import java.lang.Exception
import kotlin.concurrent.thread
var mp = MediaPlayer()
var songList= ArrayList<songInfo>()
class PlayMusic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_music)
        LoadSong.Load(this)
        val listAdapter=MusicAdapter(this,songList)
        listview.adapter=listAdapter
    }
    inner class MusicAdapter(val context:Context,val songList:ArrayList<songInfo>): BaseAdapter() {
        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val MyView = LayoutInflater.from(context).inflate(R.layout.song,null)
            val eachSong=this.songList[position]
            MyView.title.setSingleLine()
            MyView.title.isSelected=true
            MyView.title.setText(eachSong.title)
            MyView.artist.setText(eachSong.artists)
            MyView.play.setOnClickListener {
                Log.d("Hello",songList[position].songurl)
//                mp.start()
                if(mp.isPlaying){
                    mp.stop()
                    mp.reset()
                    val intent= Intent(this@PlayMusic,PlayingMusic::class.java)
                   // intent.putExtra("key",eachSong)
                    intent.putExtra("key",position)
                    context.startActivity(intent)
                }else{
                    val intent= Intent(this@PlayMusic,PlayingMusic::class.java)
                //    intent.putExtra("key",eachSong)
                    intent.putExtra("key",position)
                    context.startActivity(intent)
                }
            }
            return MyView
        }

        override fun getItem(position: Int): Any {
              return songList[position]
        }

        override fun getItemId(position: Int): Long {
             return position.toLong()
        }
        override fun getCount(): Int {
            return songList.size
        }
    }
    }
