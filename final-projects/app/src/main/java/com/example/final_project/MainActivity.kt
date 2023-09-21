package com.example.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.final_project.adapter.ListMusicAdapter
import com.example.final_project.entity.Music

class MainActivity : AppCompatActivity() {
    private lateinit var rvMusic: RecyclerView
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
        val dataLinkYoutube = resources.getStringArray(R.array.data_youtube)
        val dataLirik = resources.getStringArray(R.array.data_lirik)
        val dataSampul = resources.obtainTypedArray(R.array.data_sampul)
        val listMusic = ArrayList<Music>()
        for (i in dataJudul.indices) {
            val music = Music(
                dataJudul[i],
                dataDeskripsi[i],
                dataLinkYoutube[i],
                dataLirik[i],
                dataSampul.getResourceId(i, -1)
            )
            listMusic.add(music)
        }
        return listMusic
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
            R.id.grid_view -> {
                rvMusic.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.list_view -> {
                rvMusic.layoutManager = LinearLayoutManager(this)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}