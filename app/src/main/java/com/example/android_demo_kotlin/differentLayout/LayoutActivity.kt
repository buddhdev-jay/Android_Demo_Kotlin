package com.example.android_demo_kotlin.differentLayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.activity_layout.btn_constraint
import kotlinx.android.synthetic.main.activity_layout.btn_framelayout
import kotlinx.android.synthetic.main.activity_layout.btn_gridlayout
import kotlinx.android.synthetic.main.activity_layout.btn_includelayout
import kotlinx.android.synthetic.main.activity_layout.btn_linear_layout
import kotlinx.android.synthetic.main.activity_layout.btn_relative_layout

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        btn_linear_layout.setOnClickListener {
            intent = Intent(applicationContext,LinearLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_relative_layout.setOnClickListener {
            intent = Intent(applicationContext,RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_constraint.setOnClickListener {
            intent = Intent(applicationContext,ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_framelayout.setOnClickListener {
            intent = Intent(applicationContext,FrameLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_gridlayout.setOnClickListener {
            intent = Intent(applicationContext,GridLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_includelayout.setOnClickListener {
            intent = Intent(applicationContext,IncludeandMergeActivity::class.java)
            startActivity(intent)
        }
    }
}