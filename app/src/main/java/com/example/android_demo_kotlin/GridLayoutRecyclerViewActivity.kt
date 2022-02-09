package com.example.android_demo_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_demo_kotlin.adapter.RecyclerviewGridAdapter
import com.example.android_demo_kotlin.model.People
import kotlinx.android.synthetic.main.activity_grid_layout_recycler_view.recylerview_grid

class GridLayoutRecyclerViewActivity : AppCompatActivity() {

    var PeopleList = ArrayList<People>()
    var adapter: RecyclerviewGridAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout_recycler_view)
        addPersonList()
        adapter = RecyclerviewGridAdapter(PeopleList)
        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val dividerItemDecoration =
            DividerItemDecoration(recylerview_grid.context, layoutManager.orientation)
        recylerview_grid.addItemDecoration(dividerItemDecoration)
        recylerview_grid.layoutManager = layoutManager
        recylerview_grid.adapter = adapter
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