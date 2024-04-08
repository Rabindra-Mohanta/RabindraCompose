package com.example.rabindracompose.domain.model.home

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class PhotosData(val albumId:Int,@PrimaryKey(autoGenerate = false) val id:Int,val title:String,val url:String,val  thumbnailUrl:String) :
    Parcelable
