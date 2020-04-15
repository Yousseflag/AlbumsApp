package source

import kotlinx.coroutines.flow.Flow
import model.Album
import model.Photo

interface PhotoDataSource {

    suspend fun getAlbums(): Flow<List<Album>>
    fun getPhotos(): Flow<List<Photo>>
    suspend fun addAllPhotos(items: List<Photo>)
}