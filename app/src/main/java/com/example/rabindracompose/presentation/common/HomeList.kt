package com.example.rabindracompose.presentation.common
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.example.rabindracompose.domain.model.home.PhotosData
import com.example.rabindracompose.presentation.Dimens

@Composable
fun HomeList(photoDataList: LazyPagingItems<PhotosData>, onClick:(PhotosData)->Unit)
{
    LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1), contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2)) {
        items(count = photoDataList.itemCount)
        {position->
            val photosData = photoDataList[position]
            photosData?.let {
                HomeItem(photosData = it,onClick = {onClick(it)})

            }
        }

    }
}

