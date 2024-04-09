package com.example.rabindracompose.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rabindracompose.domain.model.home.PhotosData

@Dao
interface PhotosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: List<PhotosData>)

    @Query("DELETE FROM PhotosData")
    suspend fun deleteAllPhotoData()

    @Query("SELECT * FROM photosdata")
     fun getPhotoData(): PagingSource<Int, PhotosData>
}