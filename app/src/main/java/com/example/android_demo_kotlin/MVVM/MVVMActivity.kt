package com.example.android_demo_kotlin.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_demo_kotlin.MVVM.viewmodels.RecyclerActivityViewModel
import com.example.android_demo_kotlin.R

class MVVMActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmactivity)

        val recyclerViewModel = RecyclerActivityViewModel()
        recyclerViewModel.makeApiCall()
        recyclerViewModel.recyclerListData.observe(this,{

        })
    }
}