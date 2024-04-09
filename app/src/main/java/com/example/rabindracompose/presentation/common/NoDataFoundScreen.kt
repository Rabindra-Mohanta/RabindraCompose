package com.example.rabindracompose.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NoDataFoundScreen()
{
    Box(modifier = Modifier.fillMaxSize())
    {
        Text(text = "No Data Found", modifier = Modifier.align(alignment = Alignment.Center))
    }
}