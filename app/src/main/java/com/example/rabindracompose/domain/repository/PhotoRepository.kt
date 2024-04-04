package com.example.rabindracompose.domain.repository

import androidx.paging.PagingData
import com.example.rabindracompose.domain.model.home.PhotosData
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    fun getPhoto():Flow<PagingData<PhotosData>>
}

