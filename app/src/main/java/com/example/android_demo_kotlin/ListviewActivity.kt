package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.example.android_demo_kotlin.adapter.PersonAdapter
import com.example.android_demo_kotlin.model.Person
import com.example.android_demo_kotlin.utils.ZERO
import kotlinx.android.synthetic.main.activity_listview.list

class ListviewActivity : AppCompatActivity() {
    var personList = ArrayList<Person>()
    var adapter : PersonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        addPersonList()
        adapter = PersonAdapter(this,personList)
        list.adapter = adapter
        var person = Person("xyz","Rajkot",R.drawable.img_avtar)
        personList.add(ZERO,person)
        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, i, _ ->
            Toast.makeText(this, personList[i].name,Toast.LENGTH_SHORT).show()
        }

    }

    private fun addPersonList() {
        personList.apply {
            add(Person("Jay","Rajkot",R.drawable.img_avtar))
            add(Person("Jay","Rajkot",R.drawable.img_avtar))
        }
    }
}