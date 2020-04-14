package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import model.AlbumView
import model.PhotoEntity

@Dao
interface PhotoDao {

    @Query("SELECT * FROM albumview")
    fun getAlbums(): Flow<List<AlbumView>>

    @Query("SELECT * FROM photo_entity where album_id=:album_id")
    fun getAlbumPhotos(album_id: Long): Flow<List<PhotoEntity>>

    @Query("SELECT * FROM photo_entity where id=:id")
    fun getById(id: Long): Flow<PhotoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(articles: List<PhotoEntity>)
}