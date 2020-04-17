package lbc.testech.albumsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_photo_list.*
import kotlinx.android.synthetic.main.fragment_photo_list.view.*
import lbc.testech.albumsapp.R
import lbc.testech.albumsapp.adapter.PhotoListAdapter
import lbc.testech.albumsapp.utils.FRAGMENT_ARG_ALBUM_ID
import lbc.testech.albumsapp.utils.SWIPE_DISTANCE_TO_SYNC
import lbc.testech.albumsapp.viewmodel.AlbumViewModel
import lbc.testech.albumsapp.viewmodel.PhotosListViewModel
import model.Photo
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class PhotosListFragment :
Fragment(), KoinComponent
{
    private val photosListViewModel: PhotosListViewModel by viewModel()
    private val albumViewModel: AlbumViewModel by sharedViewModel()
    private lateinit var adapter: PhotoListAdapter

    companion object {
        fun newInstance(albumId: Long): PhotosListFragment =
            PhotosListFragment().apply {
                val bundle = Bundle()
                bundle.putLong(FRAGMENT_ARG_ALBUM_ID, albumId)
                arguments = bundle
            }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_photo_list, container, false)
        initPhotosListAdapter(rootView)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = PhotoListAdapter(albumViewModel)
        initAlbumsObserver()
        arguments?.let {
            val id = it.getLong(FRAGMENT_ARG_ALBUM_ID)
            photosListViewModel.loadPhotos(id)
        }
    }

    private fun initAlbumsObserver() {
        photosListViewModel.result.observe(this, Observer { result ->
            updatePhotos(result)
        })
    }
    private fun initPhotosListAdapter(view: View?) {
        view?.fg_photos_rv?.adapter = adapter
        view?.fg_photos_rv?.setHasFixedSize(false)
        view?.fg_photos_rv?.layoutManager = GridLayoutManager(context,2)
    }

    private fun updatePhotos(newPhotos: List<Photo>?) {
        if (newPhotos != null) adapter.updatePhotos(newPhotos)
        fg_photos_rv.scheduleLayoutAnimation()
    }
}