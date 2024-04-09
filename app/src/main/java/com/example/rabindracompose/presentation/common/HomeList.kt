package com.example.rabindracompose.presentation.common

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.rabindracompose.domain.model.home.PhotosData
import com.example.rabindracompose.presentation.Dimens

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeList(photoDataList: LazyPagingItems<PhotosData>, onClick: (PhotosData) -> Unit) {

    val handlePagingResult = handlePagingResult(photoDataList = photoDataList)

    if (handlePagingResult) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1),
            contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2)
        ) {
            items(count = photoDataList.itemCount)
            { position ->
                val photosData = photoDataList[position]
                photosData?.let {
                    HomeItem(photosData = it, onClick = { onClick(it) })
                }
            }
        }
    }

}



@Composable
fun handlePagingResult(photoDataList: LazyPagingItems<PhotosData>):Boolean
{
    val loadState = photoDataList.loadState
    val error = when{
        loadState.refresh is LoadState.Error ->loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error ->loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error ->loadState.append as LoadState.Error
        else ->null
    }

    return when
    {
        loadState.refresh is LoadState.Loading ->
        {
            ShimmerEffect()
            false
        }
        error !=null ->
        {
            true
        }
        else->
        {
            true
        }

    }
}

@Composable
fun ShimmerEffect()
{
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        repeat(10)
        {
            HomeShimmerEffect()
        }
    }
}




