package com.ako.completcontact.VideoPlayer

import android.content.Context
import android.provider.MediaStore
import com.ako.completcontact.videoList

object LoadVideo {
    fun Loadvideo(resolve: Context){
  //      val allsongurl= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val videos=MediaStore.Video.Media.EXTERNAL_CONTENT_URI
  //      val selection= MediaStore.Audio.Media.IS_MUSIC+"!=0"
        val cur0 = resolve.contentResolver.query(videos,null,null,null,null)
        if (cur0!=null){
            if (cur0!!.moveToFirst()){
                do{
                   val videourl=cur0.getString(cur0.getColumnIndex(MediaStore.Video.Media.DATA))
                    val videtitle=cur0.getString(cur0.getColumnIndex(MediaStore.Video.Media.TITLE))
     //               val songtitle=cur0.getString(cur0.getColumnIndex(MediaStore.Audio.Media.TITLE))
                    videoList.add(videoInfo(videtitle,videourl))
                }while (cur0!!.moveToNext())
            }
        }
    }
}