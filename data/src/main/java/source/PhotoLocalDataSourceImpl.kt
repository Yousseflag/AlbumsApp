package source

import AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mapper.AlbumViewMapper
import mapper.PhotoEntityMapper
import model.Album
import model.Photo

class PhotoLocalDataSourceImpl(private val mapperView: AlbumViewMapper, private val mapper: PhotoEntityMapper, private val db: AppDatabase) :
    PhotoLocalDataSource {

    override suspend fun getAlbums(): Flow<List<Album>> =
        db.photoDao().getAlbums().map { list ->
            list.map {
                mapperView.mapFromEntity(it)
            }
        }

    override fun getPhotos(albumId: Long): Flow<List<Photo>> =
        db.photoDao().getAlbumPhotos(albumId).map { list ->
            list.map { mapper.mapFromEntity(it) }
        }

    override suspend fun addAllPhotos(items: List<Photo>) =
        db.photoDao().insertAll(items.map {
            mapper.mapToEntity(it)
        })


}