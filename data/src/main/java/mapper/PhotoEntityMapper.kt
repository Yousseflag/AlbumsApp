package mapper

import model.Photo
import model.PhotoEntity

class PhotoEntityMapper : Mapper<PhotoEntity, Photo> {

    override fun mapFromEntity(type: PhotoEntity): Photo =
        Photo(type.id,type.album_id, type.title, type.url, type.thumbnail_url)

    override fun mapToEntity(type: Photo): PhotoEntity =
        PhotoEntity(type.id,type.albumId, type.title, type.url, type.thumbnail)
}