package di

import api.AlbumsApi
import org.koin.dsl.module

val apiModule = module {

    single { ServiceGenerator.createService(AlbumsApi::class.java) }
}