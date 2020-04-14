package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_entity")
data class PhotoEntity (
    @PrimaryKey
    val id: Long,
    val album_id: Long,
    val title: String,
    val url: String,
    val thumbnail_url: String
)