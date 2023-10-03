package com.lafimsize.bitmapsavetoroom.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BitmapDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBitmap(bitmapPerson: BitmapPerson)
}