package di

import mapper.AlbumViewMapper
import mapper.PhotoEntityMapper
import mapper.PhotoModelMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module
import source.PhotoLocalDataSource
import source.PhotoLocalDataSourceImpl
import source.PhotoRemoteDataSource
import source.PhotoRemoteDataSourceImpl

val dataModules = module {

    single { AppDatabase.getInstance(get()) }

    factory { PhotoEntityMapper() }

    factory { AlbumViewMapper() }

    factory { PhotoModelMapper() }

    single(named("local")) { PhotoLocalDataSourceImpl(get(), get(), get()) as PhotoLocalDataSource }

    single(named("remote")) { PhotoRemoteDataSourceImpl(get(), get()) as PhotoRemoteDataSource }
}