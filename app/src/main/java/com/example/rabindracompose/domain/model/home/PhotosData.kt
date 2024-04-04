package com.example.rabindracompose.domain.model.home

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotosData(val albumId:Int,@PrimaryKey(autoGenerate = false) val id:Int,val title:String,val url:String,val  thumbnailUrl:String)
