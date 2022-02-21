package com.example.android_demo_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_demo_kotlin.adapter.ViewpageTwoAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pagertwo.tab_layouttwo
import kotlinx.android.synthetic.main.activity_view_pagertwo.view_pagertwo

class ViewPagertwoActivity : AppCompatActivity() {
    private val titles = arrayOf("Recent", "My Favorite")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pagertwo)
        view_pagertwo.adapter = ViewpageTwoAdapter(this)
        TabLayoutMediator(tab_layouttwo,view_pagertwo) { tab: TabLayout.Tab, position: Int ->
            tab.setText(titles.get(position))
        }.attach()
    }
}