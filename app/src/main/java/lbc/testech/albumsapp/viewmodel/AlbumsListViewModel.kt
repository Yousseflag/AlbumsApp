package lbc.testech.albumsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import model.Album
import org.koin.core.KoinComponent
import timber.log.Timber
import usecase.FetchAlbums

class AlbumsListViewModel(
    private val fetchAlbums: FetchAlbums) : ViewModel(), KoinComponent {

    private var _result = MutableLiveData<List<Album>>()
    val result: LiveData<List<Album>>
        get() = _result

    init {
        loadAlbums()
    }

    @ExperimentalCoroutinesApi
    fun loadAlbums() {
        Timber.d("I'm working in thread ${Thread.currentThread().name}")
        viewModelScope.launch {
            fetchAlbums().collect { result ->
                _result.value = result
            }
        }
    }
}