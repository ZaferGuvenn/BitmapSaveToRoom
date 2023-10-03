package com.lafimsize.bitmapsavetoroom.room

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("BitmapPerson")
data class BitmapPerson(


    @PrimaryKey val id:Int,

    val bitmap: Bitmap
)