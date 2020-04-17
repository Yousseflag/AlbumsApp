package lbc.testech.albumsapp.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoModel (
    val id: Long,
    val albumId: Long,
    val title: String,
    val url: String,
    @SerialName("thumbnailUrl")
    val thumbnail: String
)