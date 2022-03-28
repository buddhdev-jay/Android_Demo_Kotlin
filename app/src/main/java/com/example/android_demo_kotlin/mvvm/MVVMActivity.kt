package com.example.android_demo_kotlin.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.android_demo_kotlin.mvvm.data.RecyclerList
import com.example.android_demo_kotlin.mvvm.viewmodels.RecyclerActivityViewModel
import com.example.android_demo_kotlin.mvvm.viewmodels.RecyclerviewMVVMAdapter
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.activity_mvvmactivity.recycler_view_mvvm
import kotlinx.android.synthetic.main.activity_mvvmactivity.search_btn
import kotlinx.android.synthetic.main.activity_mvvmactivity.search_text

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
        recyclerViewModel.getRecyclerListDataObserver().observe(this, Observer<RecyclerList> {  recyclerlist ->
            recyclerlist?.let {
                recyclerViewAdapter.apply {
                    setListData(recyclerlist.items)
                    notifyDataSetChanged()
                }
            } ?: kotlin.runCatching {
                Toast.makeText(this, getString(R.string.toast_api_error), Toast.LENGTH_LONG).show()
            }
        })
        search_btn.setOnClickListener {
            recyclerViewModel.makeApiCall(search_text.text.toString())
        }
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerviewMVVMAdapter()
        recycler_view_mvvm.adapter = recyclerViewAdapter
    }
}