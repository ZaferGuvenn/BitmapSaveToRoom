package com.lafimsize.bitmapsavetoroom.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BitmapDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBitmap(bitmapPerson: BitmapPerson)

    @Query("Select * from BitmapPerson")
    suspend fun getAllPerson():List<BitmapPerson>

}