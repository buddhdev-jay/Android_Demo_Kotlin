package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_navigation_view.drawerlayout
import kotlinx.android.synthetic.main.activity_navigation_view.nav_view

class NavigationViewActivity : AppCompatActivity() {

    private lateinit var actionBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_view)

        actionBarToggle = ActionBarDrawerToggle(this, drawerlayout, 0, 0)
        drawerlayout.addDrawerListener(actionBarToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()

        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.people -> {
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> {

                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawerlayout.openDrawer(nav_view)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(drawerlayout.isDrawerOpen(GravityCompat.START)){
            drawerlayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}