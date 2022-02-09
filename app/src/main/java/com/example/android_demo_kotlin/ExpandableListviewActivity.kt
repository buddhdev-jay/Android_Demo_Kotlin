package com.example.android_demo_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_demo_kotlin.adapter.ExpandableListviewAdapter
import kotlinx.android.synthetic.main.activity_expandable_listview.expandableListview

class ExpandableListviewActivity : AppCompatActivity() {
    var header: MutableList<String> = ArrayList()
    var body: HashMap<String,List<String>> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_listview)
        val cricket: MutableList<String> = ArrayList()
        cricket.apply {
            add("India")
            add("Pakistan")
            add("Australia")
            add("England")
            add("South Africa")
        }
        val football: MutableList<String> = ArrayList()
        football.apply {
            add("Brazil")
            add("Spain")
            add("Germany")
            add("Netherlands")
            add("Italy")
        }
        val basketball: MutableList<String> = ArrayList()
        basketball.apply {
            add("United States")
            add("Spain")
            add("Argentina")
            add("France")
            add("Russia")
        }
        val listofarray = arrayListOf(cricket,football,basketball)
        header.apply {
            add("abc")
            add("Cricket")
            add("Basketball")
            add("Cricket")
            add("Basketball")

        }
        for (item in header){
            body[item] = listofarray[header.indexOf(item)]
        }
        expandableListview.setAdapter(ExpandableListviewAdapter(this,header,body))
    }
}