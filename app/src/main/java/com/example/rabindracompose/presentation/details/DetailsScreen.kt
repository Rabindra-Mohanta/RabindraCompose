package com.example.rabindracompose.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rabindracompose.domain.model.home.PhotosData

@Composable
fun DetailsScreen(photosData: PhotosData) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        AsyncImage(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .size(100.dp),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current).data(photosData.thumbnailUrl)
                .build(),
            contentDescription = photosData.title
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = photosData.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}
