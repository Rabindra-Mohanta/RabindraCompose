package com.example.rabindracompose.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rabindracompose.domain.useCases.home.PhotoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val photoUseCases: PhotoUseCases) : ViewModel() {
val photoData = photoUseCases.getPhotos.invoke().cachedIn(viewModelScope)
}
