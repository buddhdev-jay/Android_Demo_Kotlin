package com.example.android_demo_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_demo_kotlin.adapter.RecyclerviewGridAdapter
import com.example.android_demo_kotlin.model.People
import com.example.android_demo_kotlin.utils.TWO
import kotlinx.android.synthetic.main.activity_grid_layout_recycler_view.recylerview_grid

class GridLayoutRecyclerViewActivity : AppCompatActivity() {
    var peopleList = ArrayList<People>()
    var recyclerAdapter: RecyclerviewGridAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout_recycler_view)
        addPersonList()
        recyclerAdapter = RecyclerviewGridAdapter(peopleList)
        val GridlLayoutManager = GridLayoutManager(this, TWO)
        GridlLayoutManager.apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        val dividerItemDecoration = DividerItemDecoration(recylerview_grid.context, GridlLayoutManager.orientation)
        recylerview_grid.apply{
            addItemDecoration(dividerItemDecoration)
            layoutManager = GridlLayoutManager
            adapter = recyclerAdapter
        }
    }

    private fun addPersonList() {
        peopleList.apply {
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