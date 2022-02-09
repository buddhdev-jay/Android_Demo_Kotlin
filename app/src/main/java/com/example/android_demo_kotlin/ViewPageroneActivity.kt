package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_demo_kotlin.adapter.ViewpageroneAdapter
import kotlinx.android.synthetic.main.activity_view_pagerone.tabLayout
import kotlinx.android.synthetic.main.activity_view_pagerone.viewPager

class ViewPageroneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pagerone)
        viewPager.adapter = ViewpageroneAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}