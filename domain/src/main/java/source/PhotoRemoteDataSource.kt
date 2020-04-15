package source

import kotlinx.coroutines.flow.Flow
import model.Photo

interface PhotoRemoteDataSource {

    suspend fun getPhotos(): Flow<List<Photo>>
}
