package com.example.rabindracompose.presentation.common
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rabindracompose.R
import com.example.rabindracompose.domain.model.home.PhotosData

@Composable
fun HomeItem(photosData: PhotosData,onClick:()->Unit) {
    Row(modifier = Modifier.fillMaxWidth().clickable { onClick()}) {
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current).data(photosData.thumbnailUrl).build(),
            contentDescription = photosData.title
        )
        Text(text = photosData.title, modifier = Modifier.align(alignment = Alignment.CenterVertically)
            .fillMaxWidth()
            .padding(start = 10.dp), style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),color = colorResource(
            id = R.color.black
        ))
    }
}
