package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_demo_kotlin.adapter.ViewPagerRecyclerAdapter
import com.example.android_demo_kotlin.model.People
import kotlinx.android.synthetic.main.activity_viewpagertwo_recyclerview.viewpagertwo_recyclerview

class ViewpagertwoRecyclerviewActivity : AppCompatActivity() {
    var PeopleList = ArrayList<People>()
    var adapter: ViewPagerRecyclerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpagertwo_recyclerview)
        addPersonList()
        viewpagertwo_recyclerview.adapter = ViewPagerRecyclerAdapter(PeopleList)
    }

    private fun addPersonList() {
        PeopleList.apply {
            add(People("Jay", true, R.drawable.img_avtar))
            add(People("abc", true, R.drawable.img_avtar))
            add(People("xyz", true, R.drawable.img_avtar))
            add(People("pqr", true, R.drawable.img_avtar))
            add(People("Jay", true, R.drawable.img_avtar))
            add(People("Jay", true, R.drawable.img_avtar))
            add(People("Jay", true, R.drawable.img_avtar))
            add(People("abc", true, R.drawable.img_avtar))
            add(People("xyz", true, R.drawable.img_avtar))
            add(People("pqr", true, R.drawable.img_avtar))
            add(People("Jay", true, R.drawable.img_avtar))
            add(People("abc", true, R.drawable.img_avtar))
            add(People("xyz", true, R.drawable.img_avtar))
            add(People("pqr", true, R.drawable.img_avtar))
            add(People("Jay", true, R.drawable.img_avtar))
            add(People("abc", true, R.drawable.img_avtar))
            add(People("xyz", true, R.drawable.img_avtar))
            add(People("pqr", true, R.drawable.img_avtar))
            add(People("Jay", true, R.drawable.img_avtar))
            add(People("abc", true, R.drawable.img_avtar))
            add(People("xyz", true, R.drawable.img_avtar))
            add(People("pqr", true, R.drawable.img_avtar))
        }
    }
}