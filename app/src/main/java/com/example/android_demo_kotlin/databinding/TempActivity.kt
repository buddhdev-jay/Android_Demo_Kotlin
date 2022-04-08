package com.example.android_demo_kotlin.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.People

class TempActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)

        var imageList = ArrayList<ImageUrlList>()
        for (i in 0..30){
            imageList.add(ImageUrlList("https://blog.hubspot.com/hubfs/what-is-a-blog-2.jpg",10,50))
        }
    }
}