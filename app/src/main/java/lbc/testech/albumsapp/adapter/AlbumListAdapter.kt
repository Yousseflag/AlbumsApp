package lbc.testech.albumsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.album_item.view.*
import lbc.testech.albumsapp.R
import lbc.testech.albumsapp.utils.AlbumsDiffCallBack
import lbc.testech.albumsapp.utils.listen
import lbc.testech.albumsapp.viewmodel.AlbumViewModel
import model.Album
import org.koin.core.KoinComponent

class AlbumListAdapter(private val albumViewModel: AlbumViewModel
) : RecyclerView.Adapter<AlbumListAdapter.AlbumViewHolder>(), KoinComponent {

    private var albums = mutableListOf<Album>()
    private lateinit var context: Context

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val albumName: TextView = itemView.album_name_tv
        val photoCount: TextView = itemView.photo_count_tv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view).listen { pos, _ ->
            val album = albums[pos]
            albumViewModel.navigateToAlbumPhotos(album.id)
        }
    }

    override fun getItemCount(): Int =
        albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.albumName.text = context.getString(R.string.album, position + 1)
        holder.photoCount.text = album.photoCount.toString()
    }

    fun updateAlbums(newAlbums: List<Album>) {
        val diffResult = DiffUtil.calculateDiff(AlbumsDiffCallBack(albums, newAlbums))
        albums.clear()
        albums.addAll(newAlbums)
        diffResult.dispatchUpdatesTo(this)
    }
}