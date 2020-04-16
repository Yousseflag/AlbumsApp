package lbc.testech.albumsapp.utils

import androidx.recyclerview.widget.DiffUtil
import model.Photo

class PhotosDiffCallBack (private val oldPhotoList: List<Photo>,
                          private val newPhotoList: List<Photo>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldPhotoList[oldItemPosition].id == newPhotoList[newItemPosition].id

    override fun getOldListSize(): Int = oldPhotoList.size

    override fun getNewListSize(): Int = newPhotoList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldPhotoList[oldItemPosition].title == newPhotoList[newItemPosition].title
}