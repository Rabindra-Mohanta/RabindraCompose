package com.example.rabindracompose.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rabindracompose.R
import com.google.gson.Gson

@Composable
fun HomeScreen() {
    val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    val photoData = homeScreenViewModel.photoData.collectAsLazyPagingItems()
    Log.e("rabindra", "data->" + photoData.itemSnapshotList.items.size)
    Box(modifier = Modifier.fillMaxSize())
    {
        Text(
            text = "Rabindra Mohanta",
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}