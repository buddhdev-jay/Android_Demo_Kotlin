package com.example.android_demo_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_coordinator_layout.toolbar
import kotlinx.android.synthetic.main.activity_coordinator_layout.toolbar_layout

class CoordinatorLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar_layout.title = title
        toolbar.setNavigationOnClickListener { v ->
            //What to do when back is clicked
            finish()
        }
    }
}