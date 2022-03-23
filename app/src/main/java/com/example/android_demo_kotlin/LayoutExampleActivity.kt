package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_layout_example.btn_blue
import kotlinx.android.synthetic.main.activity_layout_example.btn_red
import kotlinx.android.synthetic.main.activity_layout_example.txtview_one
import kotlinx.android.synthetic.main.activity_layout_example.txtview_two

class LayoutExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_example)

        btn_blue.setOnClickListener {
            if(txtview_one.isVisible && txtview_two.isVisible){
                txtview_one.visibility = View.GONE
            }else {
                txtview_one.visibility = View.VISIBLE
            }
        }
        btn_red.setOnClickListener {
            if(txtview_two.isVisible && txtview_one.isVisible){
                txtview_two.visibility = View.GONE
            }else {
                txtview_two.visibility = View.VISIBLE
            }
        }
    }
}