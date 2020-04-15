package api

import model.PhotoModel
import retrofit2.Response
import retrofit2.http.GET

interface AlbumsApi {

    companion object {
        const val API_URL = "https://static.leboncoin.fr/"
    }

    @GET("img/shared/technical-test.json")
    suspend fun getAlbums(): Response<List<PhotoModel>>
}