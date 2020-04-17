package di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import repository.PhotoRepository
import usecase.FetchAlbums
import usecase.FetchPhotos

val domainModule = module {

    single { PhotoRepository(get(named("local")), get(named("remote"))) }

    factory { FetchAlbums(get()) }

    factory { FetchPhotos(get()) }

}