package com.example.final_project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.R
import com.example.final_project.entity.Music

class ListMusicAdapter (
    private val listMusic: ArrayList<Music>
) : RecyclerView.Adapter<ListMusicAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgSampul : ImageView = itemView.findViewById(R.id.img_item_sampul)
        val tvJudul : TextView = itemView.findViewById(R.id.tv_judul)
        val tvDeskripsi : TextView = itemView.findViewById(R.id.tv_deskripsi_band)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_music, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMusic.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (judul, deskripsi, sampul) = listMusic[position]
        holder.imgSampul.setImageResource(sampul)
        holder.tvJudul.text = judul
        holder.tvDeskripsi.text = deskripsi
    }
}