package com.lafimsize.bitmapsavetoroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lafimsize.bitmapsavetoroom.databinding.BitmapsRowBinding
import com.lafimsize.bitmapsavetoroom.room.BitmapPerson

class MyGalleryAdapter(val bitmapPersonList: List<BitmapPerson>): RecyclerView.Adapter<MyGalleryAdapter.BitmapVH>() {

    private lateinit var adapterBinding: BitmapsRowBinding
    inner class BitmapVH(val holderBinding: BitmapsRowBinding):RecyclerView.ViewHolder(holderBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BitmapVH {
        val inflater=LayoutInflater.from(parent.context)
        adapterBinding= BitmapsRowBinding.inflate(inflater,parent,false)
        return BitmapVH(adapterBinding)
    }

    override fun getItemCount(): Int {
        return bitmapPersonList.size
    }

    override fun onBindViewHolder(holder: BitmapVH, position: Int) {
        holder.holderBinding.bitmapIDTV.text=bitmapPersonList[position].id.toString()
        holder.holderBinding.bitmapRowIV.load(bitmapPersonList[position].bitmap)
    }
}