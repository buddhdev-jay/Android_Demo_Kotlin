package com.example.android_demo_kotlin.databinding

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

@BindingAdapter("setText")
fun TextView.updateText(text: String?) {
    this.text = text
}
@BindingAdapter(value = ["basePrice","count"], requireAll = false)
fun TextView.finalPrice(count: Int?,basePrice: Int?) {
    if (basePrice != null) {
        if (count != null) {
            this.text = (count * basePrice).toString()
        }
    }
}
@BindingAdapter("setImageUrl")
fun ImageView.setImageUrl(imageUrl: String?){
    Picasso.get().load(imageUrl).into(this)
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