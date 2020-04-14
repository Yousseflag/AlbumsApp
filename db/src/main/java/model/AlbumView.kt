package model

import androidx.room.DatabaseView

@DatabaseView("select album_id, count(id) as photo_count from photo_entity group by album_id")
data class AlbumView(
    val album_id: Long,
    val photo_count: Long
)