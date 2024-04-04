package com.example.rabindracompose.data.remote

import com.example.rabindracompose.domain.model.home.PhotosData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("photos")
    suspend fun getPhotos(@Query("_page") page:Int,@Query("_limit") limit:Int = 10):Response<List<PhotosData>>
}
