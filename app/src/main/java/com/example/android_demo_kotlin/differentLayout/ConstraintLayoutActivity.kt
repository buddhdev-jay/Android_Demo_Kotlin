package com.example.android_demo_kotlin.differentLayout

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.activity_constraint_layout.spinner_country_constraint

class ConstraintLayoutActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
        spinner_country_constraint.onItemSelectedListener = this
        var country = resources.getStringArray(R.array.country)
        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, country)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_country_constraint.adapter = adapter
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //Will be Implemented Later
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //Will be Implemented Later
    }
}