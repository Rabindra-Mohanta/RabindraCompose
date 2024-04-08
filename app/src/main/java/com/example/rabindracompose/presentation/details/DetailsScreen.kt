package com.example.rabindracompose.presentation.details
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rabindracompose.domain.model.home.PhotosData

@Composable
fun DetailsScreen(photosData: PhotosData)
{
    Column(modifier = Modifier.fillMaxSize()) {
   AsyncImage(modifier = Modifier.align(alignment = Alignment.CenterHorizontally), contentScale = ContentScale.Crop ,model = ImageRequest.Builder(LocalContext.current).data(photosData.thumbnailUrl).build(), contentDescription = photosData.title)
   Spacer(modifier = Modifier.height(5.dp))
    Text(text = photosData.title)
    }
}
