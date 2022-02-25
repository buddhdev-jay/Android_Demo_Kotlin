package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_demo_kotlin.adapter.ExpandableRecyclerAdapter
import com.example.android_demo_kotlin.model.AppDemo
import kotlinx.android.synthetic.main.activity_expandable_recyclerview.recylerview_expandable

class ExpandableRecyclerviewActivity : AppCompatActivity() {
    val appList = ArrayList<AppDemo>()
    var adapter: ExpandableRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_recyclerview)
        addData()
        adapter = ExpandableRecyclerAdapter(appList)
        recylerview_expandable.adapter= adapter
    }

    private fun addData() {
        appList.apply {
            add(AppDemo("jay", "25/09/2021", "1.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("abc", "25/10/2021", "2.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("xyz", "25/09/2021", "1.5", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("jay", "25/09/2021", "1.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("abc", "25/10/2021", "2.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("xyz", "25/09/2021", "1.5", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("jay", "25/09/2021", "1.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("abc", "25/10/2021", "2.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("xyz", "25/09/2021", "1.5", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("jay", "25/09/2021", "1.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("abc", "25/10/2021", "2.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("xyz", "25/09/2021", "1.5", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("jay", "25/09/2021", "1.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("abc", "25/10/2021", "2.0", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
            add(AppDemo("xyz", "25/09/2021", "1.5", "this is sample copy this is sample copy this is sample copy this is sample copy this is sample copy"))
        }
    }
}