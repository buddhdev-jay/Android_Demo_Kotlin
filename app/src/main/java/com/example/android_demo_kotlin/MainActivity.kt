package com.example.android_demo_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.btn_kotlin_basic
import kotlinx.android.synthetic.main.activity_main.btn_ui_element

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_kotlin_basic.setOnClickListener {
            intent = Intent(applicationContext, Kotlin_Basic::class.java)
            startActivity(intent)
        }
        btn_ui_element.setOnClickListener {
            intent = Intent(applicationContext, UiElementActivity::class.java)
            startActivity(intent)
        }

    }
}