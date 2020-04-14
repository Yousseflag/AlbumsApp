package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoModel (
    val id: Long,
    val album_id: Long,
    val title: String,
    val url: String,
    @SerialName("thumbnailUrl")
    val thumbnail: String
)