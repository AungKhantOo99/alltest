package com.ako.completcontact.MusicPlayer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
 data class songInfo (var title:String,
                     var artists:String,
                     var songurl: String,
                      var duration:String) : Parcelable