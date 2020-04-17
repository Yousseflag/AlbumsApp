package lbc.testech.albumsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import kotlinx.android.synthetic.main.photo_item.view.*
import lbc.testech.albumsapp.R
import lbc.testech.albumsapp.utils.PhotosDiffCallBack
import lbc.testech.albumsapp.utils.USER_AGENT
import lbc.testech.albumsapp.utils.listen
import lbc.testech.albumsapp.viewmodel.AlbumViewModel
import model.Photo
import org.koin.core.KoinComponent


class PhotoListAdapter(private val albumViewModel: AlbumViewModel
) : RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder>(), KoinComponent {

    private var photos = mutableListOf<Photo>()
    private lateinit var context: Context

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.photo_iv
        val photoTitle: TextView = itemView.photo_name_tv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(view).listen { pos, _ ->
            val photo = photos[pos]
            albumViewModel.displayPhotoWithUrl(photo.url)
        }
    }

    override fun getItemCount(): Int =
        photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.photoTitle.text = photo.title
        val url = GlideUrl(
            photo.thumbnail, LazyHeaders.Builder()
                .addHeader("User-Agent", USER_AGENT)
                .build()
        )
        Glide.with(context).asBitmap().load(url).into(holder.photo)
    }

    fun updatePhotos(newPhotos: List<Photo>) {
        val diffResult = DiffUtil.calculateDiff(PhotosDiffCallBack(photos, newPhotos))
        photos.clear()
        photos.addAll(newPhotos)
        diffResult.dispatchUpdatesTo(this)
    }
}