package lbc.testech.albumsapp.di

import lbc.testech.albumsapp.adapter.AlbumListAdapter
import lbc.testech.albumsapp.viewmodel.AlbumViewModel
import lbc.testech.albumsapp.viewmodel.AlbumsListViewModel
import lbc.testech.albumsapp.viewmodel.PhotosListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { AlbumListAdapter(get()) }

    viewModel {
        AlbumViewModel()
    }

    viewModel {
        AlbumsListViewModel(
            get())
    }

    viewModel {
        PhotosListViewModel(
            get())
    }
}