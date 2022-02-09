package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.android_demo_kotlin.adapter.BottomNavigationAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation.viewPagerBottomNavigation

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var bottomNav: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav = findViewById(R.id.viewPagerBottomNavigation)
        setViewPagerAdapter()
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottomnav_home -> bottomNav.currentItem = 0
                R.id.bottomnav_search -> bottomNav.currentItem = 1
                R.id.bottomnav_menu -> bottomNav.currentItem = 2
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setViewPagerAdapter() {
        viewPagerBottomNavigation.adapter = BottomNavigationAdapter(supportFragmentManager)
    }
}