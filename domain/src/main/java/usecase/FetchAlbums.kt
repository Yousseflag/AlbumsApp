package usecase

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import model.Album
import org.slf4j.LoggerFactory
import repository.PhotoRepository

class FetchAlbums(private val photoRepository: PhotoRepository) {

    private val logger = LoggerFactory.getLogger(FetchAlbums::class.java.simpleName)

    @ExperimentalCoroutinesApi
    suspend operator fun invoke(): Flow<List<Album>> {
        logger.debug("Fetching adult albums.")
        return photoRepository.getAlbums()
    }
}