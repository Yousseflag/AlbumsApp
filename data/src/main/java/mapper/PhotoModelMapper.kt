package mapper

import lbc.testech.albumsapp.api.model.PhotoModel
import model.Photo

class PhotoModelMapper : Mapper<PhotoModel, Photo> {

    override fun mapFromEntity(type: PhotoModel): Photo =
        Photo(type.id, type.albumId,type.title, type.url, type.thumbnail)

    override fun mapToEntity(type: Photo): PhotoModel =
        throw UnsupportedOperationException("Mapping an Photo to an PhotoEntity is not available.")
}