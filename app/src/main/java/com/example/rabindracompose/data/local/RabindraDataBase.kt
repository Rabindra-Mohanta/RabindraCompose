package com.example.rabindracompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rabindracompose.domain.model.home.PhotoRemoteKeys
import com.example.rabindracompose.domain.model.home.PhotosData

@Database(entities = [PhotosData::class, PhotoRemoteKeys::class], version = 1)
abstract class RabindraDataBase : RoomDatabase() {
    abstract fun getPhotosDataDao(): PhotosDao
    abstract fun getPhotoRemoteKeysDao(): PhotoRemoteKeysDao

}