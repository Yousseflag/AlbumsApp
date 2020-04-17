package lbc.testech.albumsapp

import LBS_HOST
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import lbc.testech.albumsapp.activity.AlbumListActivity
import lbc.testech.albumsapp.utils.TestHelper
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

@LargeTest
class AlbumActivityTest : AutoCloseKoinTest() {

    private val server = MockWebServer()
    private val sharedPreferences: SharedPreferences by inject()

    @get:Rule
    val activityRule = ActivityTestRule(AlbumListActivity::class.java)

    init {
        server.start()
        server.setDispatcher(RequestDispatcher())
        sharedPreferences.edit {
            putString("lbs_host", server.url("/").toString())
            apply()
        }
        loadKoinModules(testModule)
    }

    @Test
    fun testing() {
        loadKoinModules(testModule)

    }

    @After
    fun teardown() {
        sharedPreferences.edit {
            putString("lbc_host", LBS_HOST)
            apply()
        }
        server.shutdown()
    }

    internal inner class RequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody(TestHelper.getPhotosTest())
        }
    }

}