package lbc.testech.albumsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlbumViewModel : ViewModel() {

    private var _id = MutableLiveData<Long>()
    val id: LiveData<Long>
        get() = _id

    fun navigateToAlbumPhotos(id: Long) {
        _id.postValue(id)
    }
}