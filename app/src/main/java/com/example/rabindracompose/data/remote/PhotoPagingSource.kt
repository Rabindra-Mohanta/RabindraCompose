package com.example.rabindracompose.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rabindracompose.domain.model.home.PhotosData

class PhotoPagingSource(private val api:Api):PagingSource<Int,PhotosData>() {

    private var totalPageCount = 100
    override fun getRefreshKey(state: PagingState<Int, PhotosData>): Int? {
        return state.anchorPosition?.let {ancherPosition->
            val anchorPage = state.closestPageToPosition(ancherPosition)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)

        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotosData> {
        val currentPage = params.key?:1
        return try {
            val request = api.getPhotos(currentPage,10)
            val photoRes = request.body()!!

            LoadResult.Page(data = photoRes, nextKey = if(currentPage == 100) null else currentPage+1, prevKey = if(currentPage==1) null else currentPage-1)
        }
        catch (e:Exception)
        {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }
}




