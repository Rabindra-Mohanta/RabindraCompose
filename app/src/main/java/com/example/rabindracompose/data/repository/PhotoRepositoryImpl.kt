package com.example.rabindracompose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rabindracompose.data.local.RabindraDataBase
import com.example.rabindracompose.data.remote.Api
import com.example.rabindracompose.data.remote.PhotoPagingSource
import com.example.rabindracompose.domain.model.home.PhotosData
import com.example.rabindracompose.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow

class PhotoRepositoryImpl(private val api: Api,private val rabindraDataBase: RabindraDataBase):PhotoRepository {
    @OptIn(ExperimentalPagingApi::class)
    override fun getPhoto(): Flow<PagingData<PhotosData>> {
        return Pager(config = PagingConfig(pageSize = 10, maxSize = 30), remoteMediator = PhotoPagingSource(api,rabindraDataBase) ,pagingSourceFactory = { rabindraDataBase.getPhotosDataDao().getPhotoData() }).flow
    }
}
