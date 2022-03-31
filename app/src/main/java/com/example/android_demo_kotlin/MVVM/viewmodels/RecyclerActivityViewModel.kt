package com.example.android_demo_kotlin.MVVM.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_demo_kotlin.MVVM.data.RecyclerList

class RecyclerActivityViewModel:ViewModel() {
    lateinit var recyclerListData : MutableLiveData<RecyclerList>

    init {
        recyclerListData = MutableLiveData()
    }

    fun getRecyclerListDataObserver():MutableLiveData<RecyclerList>{
        return  recyclerListData
    }
    fun makeApiCall(){

    }
}