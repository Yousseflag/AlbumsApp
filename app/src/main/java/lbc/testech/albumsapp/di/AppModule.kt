package lbc.testech.albumsapp.di

import lbc.testech.albumsapp.adapter.AlbumListAdapter
import lbc.testech.albumsapp.viewmodel.AlbumViewModel
import lbc.testech.albumsapp.viewmodel.AlbumsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { AlbumListAdapter(get()) }

    viewModel {
        AlbumsListViewModel(
            get())
    }

    viewModel {
        AlbumViewModel()
    }
}