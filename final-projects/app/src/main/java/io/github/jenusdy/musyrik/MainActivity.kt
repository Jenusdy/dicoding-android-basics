package io.github.jenusdy.musyrik

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.jenusdy.musyrik.adapter.ListMusicAdapter
import io.github.jenusdy.musyrik.entity.Music

class MainActivity : AppCompatActivity() {
    private lateinit var rvMusic: RecyclerView
    private val list = ArrayList<Music>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { v, insets ->
            val statusBarInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.setPadding(0, statusBarInsets.top, 0, 0)
            insets
        }

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