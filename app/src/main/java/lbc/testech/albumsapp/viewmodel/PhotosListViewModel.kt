package lbc.testech.albumsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import model.Photo
import org.koin.core.KoinComponent
import timber.log.Timber
import usecase.FetchPhotos

class PhotosListViewModel(private val fetchPhotos: FetchPhotos) :
    ViewModel(), KoinComponent
{
    private var _result = MutableLiveData<List<Photo>>()
    val result: LiveData<List<Photo>>
        get() = _result

    fun loadPhotos(albumId: Long) {
        Timber.d("I'm working in thread ${Thread.currentThread().name}")
        viewModelScope.launch {
            fetchPhotos(albumId).collect { result ->
                _result.value = result
            }
        }
    }
}