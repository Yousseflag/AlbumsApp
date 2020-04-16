package usecase

import kotlinx.coroutines.flow.Flow
import model.Photo
import org.slf4j.LoggerFactory
import repository.PhotoRepository

class FetchPhotos(private val photoRepository: PhotoRepository) {

    private val logger = LoggerFactory.getLogger(FetchPhotos::class.java.simpleName)

    operator fun invoke(id: Long): Flow<List<Photo>> {
        logger.debug("Fetching adult photos.")
        return photoRepository.getPhotos(id)
    }
}