package com.lafimsize.bitmapsavetoroom

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import com.lafimsize.bitmapsavetoroom.databinding.ActivityMainBinding
import com.lafimsize.bitmapsavetoroom.room.BitmapDatabase
import com.lafimsize.bitmapsavetoroom.room.BitmapPerson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val imageURL="https://avatars.githubusercontent.com/u/104844445?v=4"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            getBitmapFromUrl()?.let {
                binding.imageView.setImageBitmap(it)
                val dao=BitmapDatabase.getDatabase(applicationContext).myDao()
                val bitmapPerson=BitmapPerson(0,it)

                binding.insertRoomDBBtn.setOnClickListener {
                    lifecycleScope.launch(Dispatchers.IO){
                        dao.insertBitmap(bitmapPerson)
                    }
                }
            }
        }
    }

    private suspend fun getBitmapFromUrl(): Bitmap? {

        val request= ImageRequest.Builder(this).data(imageURL)
            .build()
        val imageBitmap= ImageLoader(this).execute(request).drawable

        return try {
            imageBitmap?.let {
                if(it is BitmapDrawable){
                    return it.bitmap
                }else{
                    return null
                }
            }
        }catch (e: Exception){
            Log.e("Error","Check Logs")
            null
        }
    }
}