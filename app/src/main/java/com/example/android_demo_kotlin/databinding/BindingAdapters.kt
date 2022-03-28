package com.example.android_demo_kotlin.databinding

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


@BindingAdapter(value = ["setText", "custom:AttrChanged"], requireAll = false)
fun EditText.updateText(text: String?, listener: InverseBindingListener) {
    if (this.text.toString() != text) {
        this.setText(text)
    }
    this.doOnTextChanged { _: CharSequence?, _: Int?, _: Int?, _: Int? ->
        listener.onChange()
    }
}

@InverseBindingAdapter(attribute = "setText", event = "custom:AttrChanged")
fun EditText.getUpdatedText(): String? {
    return this.text.toString().uppercase()
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


@BindingAdapter("app:data")
fun setData(recyclerView: RecyclerView, data: ArrayList<ImageUrlList>?) {
    data?.let {

    }
}