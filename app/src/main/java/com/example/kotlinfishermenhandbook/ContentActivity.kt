package com.example.kotlinfishermenhandbook

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.item_layout.tvTitle

class ContentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        tvTitle2.text = intent.getStringExtra("title")
        tvContent2.text = intent.getStringExtra("content")
        imV.setImageResource(intent.getIntExtra("image",R.drawable.som))
    }
}