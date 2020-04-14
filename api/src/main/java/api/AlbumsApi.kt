package api

import model.PhotoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumsApi {

    companion object {
        const val API_URL = "https://static.leboncoin.fr/"
    }

    @GET("img/shared/technical-test.json")
    suspend fun getArticles(@Query("api-key") apikey: String): Response<List<PhotoModel>>
}