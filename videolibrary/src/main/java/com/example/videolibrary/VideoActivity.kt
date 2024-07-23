package com.example.videolibrary

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView

class VideoActivity : AppCompatActivity() {

    lateinit var playerView: PlayerView
    lateinit var player: ExoPlayer
    private var toolbar: Toolbar? = null
    @OptIn(UnstableApi::class) private fun initView() {
        val url: String = "https://cs-example.obs.cn-south-1.myhuaweicloud.com/t45/%E7%B3%BB%E7%BB%9F%E6%96%87%E4%BB%B6/%E5%AE%A2%E6%9C%8D/video/%E4%B8%8B%E8%BD%BD.mp4?AccessKeyId=HKXFQ7HJT01TX8USG2RX&Expires=1752711840&Signature=15A4t%2BXEj/zFEJIsv8DJJHwQJZU%3D"

        playerView = findViewById(R.id.video_view)

        player = ExoPlayer.Builder(this).build()

        playerView.player = player

        val mediaItem = MediaItem.Builder()
            .setUri(url)
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .setMimeType(MimeTypes.VIDEO_H265)
            .build()

        val mediaSource = ProgressiveMediaSource.Factory(DefaultDataSource.Factory(this))
            .createMediaSource(mediaItem)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge()
        setContentView(R.layout.video_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        initView()
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("Tag", "我退出了吗？")
        player.release()
    }
}

