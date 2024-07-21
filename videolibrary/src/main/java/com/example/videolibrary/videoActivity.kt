package com.example.videolibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class videoActivity : AppCompatActivity() {
    private var buttonBack: Button? = null; //声明一个Button ，用来接收布局的id，来处理事件
    private var video: VideoView? = null;

    private fun initView() {
        val url = "https://v5-gzb-a.douyinvod.com/25a1c454262b6d8b8d918bf938fd280d/669d19fe/video/tos/cn/tos-cn-ve-15-alinc2/44488a526c024cae942e49d85a8d1c9c/?a=1128&ch=0&cr=0&dr=0&er=0&cd=0%7C0%7C0%7C0&cv=1&br=1336&bt=1336&cs=0&ds=4&ft=rAHInzwwZRclse~o1PDS6kFgAX1tGCCS0f9eFlVg1qV12nzXT&mime_type=video_mp4&qs=0&rc=aWU0Zzk6Mzg5aTY0ODY1M0BpM3dzdjw6ZjQ6OjMzNGkzM0AzMl8wXi5hXzYxMF82Ly5iYSNjYG5mcjRncW9gLS1kLWFzcw%3D%3D&btag=c0000e0008d200&cdn_n80=1&cquery=100y&dy_q=1721568227&l=202407212123471639EF297BAF32FAF2B2&req_cdn_type="
        val videoView = findViewById<VideoView>(R.id.video_Widget);
        videoView.setVideoPath(url)
        videoView.requestFocus()
        videoView.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initView();
    }
}

