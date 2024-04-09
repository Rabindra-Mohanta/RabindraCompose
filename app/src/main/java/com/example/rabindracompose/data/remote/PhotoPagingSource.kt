package com.example.rabindracompose.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.rabindracompose.data.local.RabindraDataBase
import com.example.rabindracompose.domain.model.home.PhotoRemoteKeys
import com.example.rabindracompose.domain.model.home.PhotosData

@OptIn(ExperimentalPagingApi::class)
class PhotoPagingSource(private val api: Api, private val rabindraDataBase: RabindraDataBase) :
    RemoteMediator<Int, PhotosData>() {
    private val photoRemoteKeysDao = rabindraDataBase.getPhotoRemoteKeysDao()
    private val photosDao = rabindraDataBase.getPhotosDataDao()
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PhotosData>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyFromFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage

                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyFromLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }

            }
            val res = api.getPhotos(currentPage, 10)
            val endOfPagination = false
            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPagination) null else currentPage + 1

            rabindraDataBase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    photosDao.deleteAllPhotoData()
                    photoRemoteKeysDao.deleteAll()
                }
                photosDao.insertData(res.body()!!)
                val keys = res.body()!!.map { data ->
                    PhotoRemoteKeys(id = data.id, prevPage = prevPage, nextPage = nextPage)
                }
                photoRemoteKeysDao.insertData(keys)
            }
            MediatorResult.Success(endOfPagination)
        } catch (e: Exception) {
            MediatorResult.Error(throwable = e)
        }
    }

    private suspend fun getRemoteKeyFromLastItem(state: PagingState<Int, PhotosData>): PhotoRemoteKeys? {
        return state.pages.lastOrNull() { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { data ->
            photoRemoteKeysDao.getRemoteKeys(id = data.id)
        }
    }

    private suspend fun getRemoteKeyFromFirstItem(state: PagingState<Int, PhotosData>): PhotoRemoteKeys? {
        return state.pages.firstOrNull() { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { data ->
                photoRemoteKeysDao.getRemoteKeys(id = data.id)

            }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, PhotosData>): PhotoRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                photoRemoteKeysDao.getRemoteKeys(id = id)
            }
        }
    }
}







