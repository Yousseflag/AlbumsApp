package lbc.testech.albumsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_albums_list.*
import kotlinx.android.synthetic.main.fragment_albums_list.view.*
import lbc.testech.albumsapp.R
import lbc.testech.albumsapp.adapter.AlbumListAdapter
import lbc.testech.albumsapp.utils.SWIPE_DISTANCE_TO_SYNC
import lbc.testech.albumsapp.viewmodel.AlbumViewModel
import lbc.testech.albumsapp.viewmodel.AlbumsListViewModel
import model.Album
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class AlbumsListFragment :
    Fragment(), KoinComponent
{
    private val albumsListViewModel: AlbumsListViewModel by viewModel()
    private val albumViewModel: AlbumViewModel by sharedViewModel()
    private lateinit var adapter: AlbumListAdapter

    companion object {
        fun newInstance(): AlbumsListFragment =
            AlbumsListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_albums_list, container, false)
        initSwipeRefreshLayout(rootView)
        initAlbumsListAdapter(rootView)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = AlbumListAdapter(albumViewModel)
        initAlbumsObserver()
    }

    private fun initAlbumsObserver() {
        albumsListViewModel.result.observe(this, Observer { result ->
            fg_albums_srl.isRefreshing = false
            updateAlbums(result)
        })
    }

    private fun initSwipeRefreshLayout(view: View?) {
        view?.fg_albums_srl?.setOnRefreshListener {
            albumsListViewModel.loadAlbums()
            fg_albums_srl.isRefreshing = true
        }
        view?.fg_albums_srl?.setDistanceToTriggerSync(SWIPE_DISTANCE_TO_SYNC)
    }

    private fun initAlbumsListAdapter(view: View?) {
        view?.fg_albums_rv?.adapter = adapter
        view?.fg_albums_rv?.layoutManager = LinearLayoutManager(context)
    }

    private fun updateAlbums(newAlbums: List<Album>?) {
        if (newAlbums != null) adapter.updateAlbums(newAlbums)
        fg_albums_rv.scheduleLayoutAnimation()
    }
}