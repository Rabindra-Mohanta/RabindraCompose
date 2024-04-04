package com.example.rabindracompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rabindracompose.domain.model.home.PhotoRemoteKeys

@Dao
interface PhotoRemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(photoRemoteKeys: PhotoRemoteKeys)

    @Query("SELECT * FROM PhotoRemoteKeys Where id=:id")
    suspend fun getRemoteKeys(id: Int?): PhotoRemoteKeys

    @Query("SELECT * FROM PhotoRemoteKeys")
    suspend fun deleteAll()
}