package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.example.android_demo_kotlin.adapter.PersonAdapter
import com.example.android_demo_kotlin.model.Person
import kotlinx.android.synthetic.main.activity_listview.list


class ListviewActivity : AppCompatActivity() {

    var PersonList = ArrayList<Person>()
    var adapter: PersonAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        addPersonList()
        adapter= PersonAdapter(this,PersonList)
        list.adapter=adapter
        var person =Person("xyz","Rajkot",R.drawable.img_avtar)
        PersonList.add(0,person)
        list.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,PersonList.get(i).name,Toast.LENGTH_SHORT).show()
        }

    }

    private fun addPersonList() {
        var person =Person("Jay","Rajkot",R.drawable.img_avtar)
        PersonList.add(person)
         person =Person("Jay","Rajkot",R.drawable.img_avtar)
        PersonList.add(person)
        //adapter?.notifyDataSetChanged()
    }
}