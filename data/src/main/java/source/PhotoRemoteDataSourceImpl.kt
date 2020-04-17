package source

import api.AlbumsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import lbc.testech.albumsapp.networking.NetworkCall
import mapper.PhotoModelMapper
import model.Photo
import org.slf4j.LoggerFactory

class PhotoRemoteDataSourceImpl(private val api: AlbumsApi,private val mapper: PhotoModelMapper) : PhotoRemoteDataSource {

    private val logger = LoggerFactory.getLogger(PhotoRemoteDataSourceImpl::class.java.simpleName)

    override suspend fun getPhotos(): Flow<List<Photo>> = flow {
        val list = mutableListOf<Photo>()
        val response = NetworkCall.safeApiResult { api.getAlbums() }
        response.body()?.forEach {
            list.add(mapper.mapFromEntity(it))
        }
        emit(list)
    }
}