package com.lafimsize.bitmapsavetoroom.room

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("BitmapPerson")
data class BitmapPerson(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val bitmap: Bitmap
)