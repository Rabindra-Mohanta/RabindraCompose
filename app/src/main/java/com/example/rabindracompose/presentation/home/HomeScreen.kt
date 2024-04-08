package com.example.rabindracompose.presentation.home
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.example.rabindracompose.domain.model.home.PhotosData
import com.example.rabindracompose.presentation.common.HomeList

@Composable
fun HomeScreen(photoDataList: LazyPagingItems<PhotosData>,onClick:(PhotosData)->Unit) {

    Column(modifier = Modifier.fillMaxSize())
    {
       HomeList(photoDataList = photoDataList ) {
           onClick(it)
       }
    }
}
