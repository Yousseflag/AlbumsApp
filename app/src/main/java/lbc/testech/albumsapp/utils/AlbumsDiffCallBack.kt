package lbc.testech.albumsapp.utils

import androidx.recyclerview.widget.DiffUtil
import model.Album

class AlbumsDiffCallBack(private val oldAlbumList: List<Album>,
                         private val newAlbumList: List<Album>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldAlbumList[oldItemPosition].id == newAlbumList[newItemPosition].id

    override fun getOldListSize(): Int = oldAlbumList.size

    override fun getNewListSize(): Int = newAlbumList.size

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldAlbumList[oldItemPosition].photoCount == newAlbumList[newItemPosition].photoCount
}