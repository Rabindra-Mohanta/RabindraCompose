package com.example.rabindracompose.domain.useCases.home

import androidx.paging.PagingData
import com.example.rabindracompose.domain.model.home.PhotosData
import com.example.rabindracompose.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow

class GetPhotos(private val photoRepository: PhotoRepository)
{
    operator fun invoke():Flow<PagingData<PhotosData>>
    {
        return photoRepository.getPhoto()
    }
}

