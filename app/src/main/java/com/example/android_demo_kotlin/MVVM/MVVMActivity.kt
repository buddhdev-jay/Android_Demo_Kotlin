package com.example.android_demo_kotlin.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.android_demo_kotlin.MVVM.data.RecyclerList
import com.example.android_demo_kotlin.MVVM.viewmodels.RecyclerActivityViewModel
import com.example.android_demo_kotlin.MVVM.viewmodels.RecyclerviewMVVMAdapter
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.activity_mvvmactivity.recycler_view_MVVM
import kotlinx.android.synthetic.main.activity_mvvmactivity.searchBoxId
import kotlinx.android.synthetic.main.activity_mvvmactivity.searchButton
import retrofit2.Call
import retrofit2.Response

class MVVMActivity : AppCompatActivity() {

    val recyclerViewModel : RecyclerActivityViewModel by viewModels()
    lateinit var recyclerViewAdapter: RecyclerviewMVVMAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmactivity)
        initRecyclerView()
        createData()
    }

    private fun createData() {
        recyclerViewModel.getRecyclerListDataObserver().observe(this, Observer<RecyclerList> {
            if (it != null) {
                recyclerViewAdapter.setListData(it.items)
                recyclerViewAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }

        })
        searchButton.setOnClickListener {
            recyclerViewModel.makeApiCall(searchBoxId.text.toString())
        }
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerviewMVVMAdapter()
        recycler_view_MVVM.adapter = recyclerViewAdapter
    }
}