package source

import kotlinx.coroutines.flow.Flow
import model.Album
import model.Photo

interface PhotoLocalDataSource {

    suspend fun getAlbums(): Flow<List<Album>>
    fun getPhotos(albumId: Long): Flow<List<Photo>>
    suspend fun addAllPhotos(items: List<Photo>)
}