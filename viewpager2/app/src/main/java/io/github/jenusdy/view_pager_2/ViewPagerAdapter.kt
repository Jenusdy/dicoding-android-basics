package io.github.jenusdy.view_pager_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ViewPagerAdapter(
    val listImage : List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageImageView : ImageView = itemView.findViewById(R.id.imageImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int = listImage.size

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentImage = listImage[position]
        holder.imageImageView.setImageResource(currentImage)
    }
}