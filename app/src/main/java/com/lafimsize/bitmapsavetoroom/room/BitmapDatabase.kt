package com.lafimsize.bitmapsavetoroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BitmapPerson::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BitmapDatabase: RoomDatabase (){

    abstract fun myDao():BitmapDao

    companion object{

        @Volatile
        private var instance:BitmapDatabase?=null

        fun getDatabase(context: Context):BitmapDatabase{
            return instance?: synchronized(this){
                instance?: buildDatabase(context).also {
                    instance=it
                }
            }
        }

        private fun buildDatabase(context:Context)= Room
            .databaseBuilder(context,BitmapDatabase::class.java,"BitmapDatabase")
            .build()
    }
}