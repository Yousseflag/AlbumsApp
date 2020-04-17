package lbc.testech.albumsapp.utils

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import lbc.testech.albumsapp.api.model.PhotoModel
import java.nio.charset.StandardCharsets

object TestHelper {

    private val context = InstrumentationRegistry.getInstrumentation().context

    private fun readJSONFromAsset(filename: String): String? {
        var json: String? = null
        try {
            val output = context.assets.open(filename)
            json = output.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            Log.d("log", "The length of json photo inside catch is : ${json?.length}")
            return null
        }
        Log.d("log", "The length of json photo is : ${json.length}")
        return json
    }

    fun getPhotosTest() : String? = readJSONFromAsset( "photos.json")

}