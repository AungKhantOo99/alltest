package com.ako.completcontact.MusicPlayer

import android.annotation.SuppressLint
import android.content.Context
import android.provider.MediaStore
import com.ako.completcontact.songList

object LoadSong {
    @SuppressLint("Recycle")
    fun Load(resolve:Context){
        val allsongurl= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val selection= MediaStore.Audio.Media.IS_MUSIC+"!=0"
        val cur0 = resolve.contentResolver.query(allsongurl,null,selection,null,null)
        if (cur0!=null){
            if (cur0.moveToFirst()){
                do{
                    val songurl=cur0.getString(cur0.getColumnIndex(MediaStore.Audio.Media.DATA))
                    val songtitle=cur0.getString(cur0.getColumnIndex(MediaStore.Audio.Media.TITLE))
                    val songartis=cur0.getString(cur0.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                    val songduration=cur0.getString(cur0.getColumnIndex(MediaStore.Audio.Media.DURATION))
                    songList.add(songInfo(songtitle,songartis,songurl,songduration))
                }while (cur0.moveToNext())
            }
        }
    }
    fun calculatelength(dura:Int):String{
        var time=""
        val min= (dura/1000/60).toString()
        val sec=(dura/1000%60).toString()
        time += min + ":"
        if(sec.toInt() < 10)time+="0"
        time+=sec
        return time
    }
}