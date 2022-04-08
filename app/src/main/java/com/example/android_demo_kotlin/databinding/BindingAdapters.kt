package com.example.android_demo_kotlin.databinding

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("setText")
fun TextView.updateText(text: String?) {
    this.text = text
}

@InverseBindingAdapter(attribute = "setText")
fun EditText.getUpdatedText(): String {
    return this.text.toString().uppercase()
}

@BindingAdapter("app:data")
fun setData(recyclerView: RecyclerView, data: ArrayList<ImageUrlList>?) {
    data?.let {

    }
}