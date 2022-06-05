package com.ako.completcontact

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.ako.completcontact.MusicPlayer.LoadSong
import com.ako.completcontact.MusicPlayer.songInfo
import kotlinx.android.synthetic.main.activity_playing_music.*
import java.lang.Exception
import java.text.SimpleDateFormat

class PlayingMusic : AppCompatActivity() {
      lateinit var state:String
     @SuppressLint("SimpleDateFormat")
     var timeFormat=SimpleDateFormat("hh:mm:ss")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing_music)
        var eachposition=intent.extras?.get("key").toString().toInt()
        val song=songTurck(eachposition)
        song.start()
        LoadSong.Load(this)
        LoadMusic(eachposition)
        songSeek.max= mp.duration
        playplaus.setImageResource(R.drawable.pause)
        playplaus.setOnClickListener {
            if(mp.isPlaying){
                playplaus.setImageResource(R.drawable.play)
                mp.pause()
                state="1"
                Log.d("state",state)
            }else{
                playplaus.setImageResource(R.drawable.pause)
                mp.start()
            }
        }
        pre.setOnClickListener {
            eachposition--
            LoadMusic(eachposition)
        }
        next.setOnClickListener {
            eachposition++
            LoadMusic(eachposition)
        }
        songSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                val resu=LoadSong.calculatelength(mp.currentPosition)
                songcurrentMinute.text=resu
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                mp.seekTo(seekBar!!.progress)

            }
        })

    }
     inner class songTurck(var ep:Int):Thread(){
        override fun run() {
            while (true){
                try {
                    Thread.sleep(1000)
                }catch (es: Exception){}
                runOnUiThread {
                    if(songcurrentMinute.text.equals(songMinute.text)){
                        ep++
                        LoadMusic(ep)
                    }
                    songSeek.progress=mp.currentPosition
                }
            }
        }
    }
    fun LoadMusic(posi:Int){
        if(true){
            mp.stop()
            mp.reset()
            songname.setText(songList[posi].title)
            songArtist.setText(songList[posi].artists)
            mp.setDataSource(songList[posi].songurl)
            val res=LoadSong.calculatelength(songList[posi].duration.toInt())
            songMinute.text= res
            mp.prepare()
            mp.start()
        }else
        {
            songname.setText(songList[posi].title)
            songArtist.setText(songList[posi].artists)
            mp.setDataSource(songList[posi].songurl)
            val result= LoadSong.calculatelength(songList[posi].duration.toInt())
            songMinute.text= result
            mp.prepare()
            mp.start()
        }

    }
}
