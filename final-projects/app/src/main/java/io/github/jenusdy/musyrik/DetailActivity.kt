package io.github.jenusdy.musyrik

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import io.github.jenusdy.musyrik.entity.Music
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class DetailActivity : AppCompatActivity() {
    private lateinit var youtubePlayerView: YouTubePlayerView
    private lateinit var judulTextView : TextView
    private lateinit var lirikTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { v, insets ->
            val statusBarInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.setPadding(0, statusBarInsets.top, 0, 0)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataMusic = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Music>("key_music", Music::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Music>("key_music")
        }

        if (dataMusic != null) {
            supportActionBar?.title = dataMusic.judul
        }

        youtubePlayerView = findViewById(R.id.youtube_player_view)
        judulTextView = findViewById(R.id.tv_judul)
        lirikTextView = findViewById(R.id.tv_lirik)

        judulTextView.text = dataMusic?.judul
        lirikTextView.text = dataMusic?.lirik

        youtubePlayerView.enableAutomaticInitialization = false
        youtubePlayerView.initialize(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = dataMusic?.youtubeID
                if (videoId != null) {
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.action_share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text));
                startActivity(Intent.createChooser(shareIntent,getString(R.string.send_to)))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}