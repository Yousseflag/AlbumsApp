package lbc.testech.albumsapp

import android.app.Application
import com.facebook.stetho.Stetho
import di.apiModule
import di.dataModule
import di.domainModule
import lbc.testech.albumsapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class AlbumsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        if (GlobalContext.getOrNull() == null) { // Used to prevent Robolectric to startKoin multiple times
            startKoin {
                if (BuildConfig.DEBUG) {
                    androidLogger(Level.DEBUG)
                } else {
                    androidLogger(Level.INFO)
                }
                androidContext(this@AlbumsApplication)
                androidFileProperties()
                modules(listOf(appModule, dataModule, domainModule, apiModule))
            }
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}