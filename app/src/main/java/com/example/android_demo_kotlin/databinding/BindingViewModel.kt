package com.example.android_demo_kotlin.databinding

import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide

class BindingViewModel:ViewModel() {

    var intvalue = ""
    val name = MutableLiveData<String>()
    @BindingAdapter("android:text")
    fun EditText.integerValue(value: Int){
        this.setText(value.toString())
    }
    @InverseBindingAdapter(attribute = "android:text")
    fun getstring(input: String):String{
        intvalue = input
        return intvalue
    }
}