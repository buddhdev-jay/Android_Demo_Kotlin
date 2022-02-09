package com.example.android_demo_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_demo_kotlin.differentLayout.LayoutActivity
import kotlinx.android.synthetic.main.activity_main.btn_bottomnavigation
import kotlinx.android.synthetic.main.activity_main.btn_expandable_listview
import kotlinx.android.synthetic.main.activity_main.btn_expandable_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_kotlin_basic
import kotlinx.android.synthetic.main.activity_main.btn_layouts
import kotlinx.android.synthetic.main.activity_main.btn_listview
import kotlinx.android.synthetic.main.activity_main.btn_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_recyclerview_grid
import kotlinx.android.synthetic.main.activity_main.btn_ui_element
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_one
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_two

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
        btn_layouts.setOnClickListener {
            intent = Intent(applicationContext, LayoutActivity::class.java)
            startActivity(intent)
        }
        btn_listview.setOnClickListener {
            intent = Intent(applicationContext, ListviewActivity::class.java)
            startActivity(intent)
        }
        btn_recyclerview.setOnClickListener {
            intent = Intent(applicationContext, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btn_recyclerview_grid.setOnClickListener {
            intent = Intent(applicationContext,GridLayoutRecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager_one.setOnClickListener {
            intent = Intent(applicationContext,ViewPageroneActivity::class.java)
            startActivity(intent)
        }
       btn_viewpager_two.setOnClickListener {
            intent = Intent(applicationContext,ViewPagertwoActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager_recyclerview.setOnClickListener {
            intent = Intent(applicationContext,ViewpagertwoRecyclerviewActivity::class.java)
            startActivity(intent)
        }
       btn_expandable_recyclerview.setOnClickListener {
            intent = Intent(applicationContext,ExpandableRecyclerviewActivity::class.java)
            startActivity(intent)
        }
        btn_expandable_listview.setOnClickListener {
            intent = Intent(applicationContext,ExpandableListviewActivity::class.java)
            startActivity(intent)
        }
        btn_bottomnavigation.setOnClickListener {
            intent = Intent(applicationContext,BottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }
}