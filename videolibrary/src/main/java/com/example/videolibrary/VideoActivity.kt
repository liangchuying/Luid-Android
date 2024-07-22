package com.example.videolibrary

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoActivity : AppCompatActivity() {

    private fun initView() {
        val url: String = "https://cs-example.obs.cn-south-1.myhuaweicloud.com/t45/%E7%B3%BB%E7%BB%9F%E6%96%87%E4%BB%B6/%E5%AE%A2%E6%9C%8D/video/%E4%B8%8B%E8%BD%BD.mp4?AccessKeyId=HKXFQ7HJT01TX8USG2RX&Expires=1752711840&Signature=15A4t%2BXEj/zFEJIsv8DJJHwQJZU%3D"
        val videoView = findViewById<VideoView>(R.id.video_widget);
        videoView.setVideoPath(url)
        videoView.requestFocus()
        videoView.start()
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

        initView();

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}

