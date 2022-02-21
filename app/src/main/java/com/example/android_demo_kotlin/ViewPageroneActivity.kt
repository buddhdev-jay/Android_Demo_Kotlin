package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_demo_kotlin.adapter.ViewpageroneAdapter
import kotlinx.android.synthetic.main.activity_view_pagerone.tab_layout
import kotlinx.android.synthetic.main.activity_view_pagerone.view_pager

class ViewPageroneActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pagerone)
        view_pager.adapter = ViewpageroneAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }
}