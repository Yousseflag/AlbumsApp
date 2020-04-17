package lbc.testech.albumsapp

import api.AlbumsApi
import org.koin.dsl.module

val testModule = module {
    single(override = true) { ServiceGeneratorTest.createService(AlbumsApi::class.java)}
}