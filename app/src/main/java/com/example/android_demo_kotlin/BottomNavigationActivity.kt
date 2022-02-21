package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.android_demo_kotlin.adapter.BottomNavigationAdapter
import com.example.android_demo_kotlin.utils.ONE
import com.example.android_demo_kotlin.utils.TW0
import com.example.android_demo_kotlin.utils.ZERO
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation.view_pager_bottom_navigation

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var bottomNav: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav = findViewById(R.id.view_pager_bottom_navigation)
        setViewPagerAdapter()
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottomnav_home -> bottomNav.currentItem = ZERO
                R.id.bottomnav_search -> bottomNav.currentItem = ONE
                R.id.bottomnav_menu -> bottomNav.currentItem = TW0
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setViewPagerAdapter() {
        view_pager_bottom_navigation.adapter = BottomNavigationAdapter(supportFragmentManager)
    }
}