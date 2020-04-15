package repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import model.Album
import model.Photo
import org.slf4j.LoggerFactory
import source.PhotoDataSource
import source.PhotoLocalDataSource
import source.PhotoRemoteDataSource

class PhotoRepository(private val localSource: PhotoLocalDataSource,
                      private val remoteSource: PhotoRemoteDataSource
) : PhotoDataSource {

    private val logger = LoggerFactory.getLogger(PhotoRepository::class.java.simpleName)

    override suspend fun getAlbums(): Flow<List<Album>> = withContext(Dispatchers.IO) {
        async {
            logger.debug("Collecting on remote...")
            remoteSource.getPhotos()
                .catch {
                    emptyList<Photo>()
                }.onEach {
                    addAllPhotos(it)
                }.collect()

        }
        localSource.getAlbums()
    }

    override fun getPhotos(albumId: Long): Flow<List<Photo>> =
        localSource.getPhotos(albumId)

    override suspend fun addAllPhotos(items: List<Photo>) =
        localSource.addAllPhotos(items)

}