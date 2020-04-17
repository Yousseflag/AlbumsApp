import android.content.SharedPreferences
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.ConnectionSpec
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Retrofit

object ServiceGeneratorTest : KoinComponent {
    private val httpClient = OkHttpClient.Builder().protocols(listOf(Protocol.HTTP_1_1)).connectionSpecs(
        listOf(ConnectionSpec.CLEARTEXT))
    private val sharedPreferences: SharedPreferences by inject()

    private val contentType = MediaType.get("application/json")
    private val jsonConfiguration = JsonConfiguration(encodeDefaults = false, strictMode = false, indent = "    ")
    private val jsonConverterFactory = Json(jsonConfiguration).asConverterFactory(contentType)
    private val baseUrl =
        sharedPreferences.getString("lbs_host", null) ?: LBS_HOST

    private val builder = Retrofit.Builder()
        .addConverterFactory(jsonConverterFactory)

    fun <S> createService(serviceClass: Class<S>): S {
        builder.baseUrl(baseUrl)
            .client(httpClient.build())
        val retrofit = builder.build()

        return retrofit.create(serviceClass)
    }
}