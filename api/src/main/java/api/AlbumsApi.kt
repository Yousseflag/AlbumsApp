package api

import lbc.testech.albumsapp.api.model.PhotoModel
import retrofit2.Response
import retrofit2.http.GET

interface AlbumsApi {

    @GET("/img/shared/technical-test.json")
    suspend fun getAlbums(): Response<List<PhotoModel>>
}