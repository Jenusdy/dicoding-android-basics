package com.example.final_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.adapter.ListMusicAdapter
import com.example.final_project.entity.Music

class MainActivity : AppCompatActivity() {
    private lateinit var rvMusic : RecyclerView
    private val list = ArrayList<Music>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMusic = findViewById(R.id.rv_music)
        rvMusic.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMusic.layoutManager = LinearLayoutManager(this)
        rvMusic.adapter = ListMusicAdapter(list)
    }

    private fun getListHeroes(): Collection<Music> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)
        val dataSampul = resources.obtainTypedArray(R.array.data_sampul)
        val listMusic = ArrayList<Music>()
        for (i in dataJudul.indices) {
            val music = Music(dataJudul[i], dataDeskripsi[i], dataSampul.getResourceId(i, -1))
            listMusic.add(music)
        }
        return listMusic
    }
}