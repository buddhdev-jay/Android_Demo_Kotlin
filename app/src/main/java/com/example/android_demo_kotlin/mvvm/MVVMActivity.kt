package com.example.android_demo_kotlin.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.android_demo_kotlin.mvvm.data.RecyclerList
import com.example.android_demo_kotlin.mvvm.viewmodels.RecyclerActivityViewModel
import com.example.android_demo_kotlin.mvvm.viewmodels.RecyclerviewMVVMAdapter
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.databinding.ActivityMvvmactivityBinding
import kotlinx.android.synthetic.main.activity_mvvmactivity.recycler_view_MVVM

class MVVMActivity : AppCompatActivity() {

    lateinit var binding: ActivityMvvmactivityBinding
    val recyclerViewModel: RecyclerActivityViewModel by viewModels()
    lateinit var recyclerViewAdapter: RecyclerviewMVVMAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmactivity)
        binding.mainviewModel = recyclerViewModel
        binding.lifecycleOwner = this
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
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerviewMVVMAdapter()
        recycler_view_MVVM.adapter = recyclerViewAdapter
    }
}