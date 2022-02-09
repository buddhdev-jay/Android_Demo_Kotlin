package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.android_demo_kotlin.adapter.RecyclerviewAdapter
import com.example.android_demo_kotlin.model.People
import com.example.android_demo_kotlin.utils.THREE_THOUSAND
import kotlinx.android.synthetic.main.activity_recycler_view.recylerview_person

class RecyclerViewActivity : AppCompatActivity() {

    var peopleList = ArrayList<People>()
    var adapter : RecyclerviewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        addPersonList()
        adapter = RecyclerviewAdapter(peopleList) {
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
        }
        recylerview_person.adapter = adapter
        Handler(Looper.getMainLooper()).postDelayed({  addPersonList2() }, THREE_THOUSAND.toLong())
    }

    private fun addPersonList2() {
        peopleList.apply {
            add(People("Jay", true, R.drawable.img_avtar))
            add(People("Vishal", true, R.drawable.img_avtar))
            add(People("shjgfjs", true, R.drawable.img_avtar))
        }
        adapter?.notifyDataSetChanged()
    }

    private fun addPersonList() {
        peopleList.apply {
            add(People("Jay",true,R.drawable.img_avtar))
            add(People("abc",true,R.drawable.img_avtar))
            add(People("xyz",true,R.drawable.img_avtar))
            add(People("pqr",true,R.drawable.img_avtar))
            add(People("Jay",true,R.drawable.img_avtar))
            add(People("Jay",true,R.drawable.img_avtar))
            add(People("Jay",true,R.drawable.img_avtar))
            add(People("abc",true,R.drawable.img_avtar))
            add(People("xyz",true,R.drawable.img_avtar))
            add(People("pqr",true,R.drawable.img_avtar))
            add(People("Jay",true,R.drawable.img_avtar))
            add(People("abc",true,R.drawable.img_avtar))
            add(People("xyz",true,R.drawable.img_avtar))
            add(People("pqr",true,R.drawable.img_avtar))
            add(People("Jay",true,R.drawable.img_avtar))
            add(People("abc",true,R.drawable.img_avtar))
            add(People("xyz",true,R.drawable.img_avtar))
            add(People("pqr",true,R.drawable.img_avtar))
            add(People("Jay",true,R.drawable.img_avtar))
            add(People("abc",true,R.drawable.img_avtar))
            add(People("xyz",true,R.drawable.img_avtar))
            add(People("pqr",true,R.drawable.img_avtar))
        }
    }
}