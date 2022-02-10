package com.example.android_demo_kotlin.differentLayout

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_demo_kotlin.R
import java.util.Arrays
import kotlinx.android.synthetic.main.activity_linear_layout.editxt_feedback_linear
import kotlinx.android.synthetic.main.activity_linear_layout.spinner_country

class LinearLayoutActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)
        spinner_country.onItemSelectedListener = this
        var country = resources.getStringArray(R.array.country)
        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, country)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_country.adapter = adapter

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, postion: Int, p3: Long) {
        //Will be Implemented Later
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //Will be Implemented Later
    }

}