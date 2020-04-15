package mapper

import model.Album
import model.AlbumView

class AlbumViewMapper : Mapper<AlbumView, Album> {

    override fun mapFromEntity(type: AlbumView): Album =
            Album(type.album_id, type.photo_count)

    override fun mapToEntity(type: Album): AlbumView =
        AlbumView(type.id, type.photoCount)
}