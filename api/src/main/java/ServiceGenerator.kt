import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object ServiceGenerator {
    private val httpClient = OkHttpClient.Builder()

    private val contentType = MediaType.get("application/json")
    private val jsonConfiguration = JsonConfiguration(encodeDefaults = false, strictMode = false, indent = "    ")
    private val jsonConverterFactory = Json(jsonConfiguration).asConverterFactory(contentType)

    private val builder = Retrofit.Builder()
        .addConverterFactory(jsonConverterFactory)

    fun <S> createService(baseUrl: String, serviceClass: Class<S>): S {
        builder.baseUrl(baseUrl)
            .client(httpClient.build())
        val retrofit = builder.build()

        return retrofit.create(serviceClass)
    }
}