package com.example.rabindracompose.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rabindracompose.R

@Composable
fun HomeScreen() {
    val homeScreenViewModel:HomeScreenViewModel = hiltViewModel()
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