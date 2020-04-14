package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import model.PhotoEntity

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photo_entity")
    fun getAllPhotos(): Flow<List<PhotoEntity>>

    @Query("SELECT * FROM photo_entity where id=:id")
    fun getById(id: Long): Flow<PhotoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(articles: List<PhotoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: PhotoEntity)
}