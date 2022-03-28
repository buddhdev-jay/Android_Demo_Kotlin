package com.example.android_demo_kotlin.MVVM.viewmodels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_demo_kotlin.MVVM.data.RecyclerData
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.recyclerview_row_mvvm.view.img_recylerview_item

class RecyclerviewMVVMAdapter: RecyclerView.Adapter<RecyclerviewMVVMAdapter.MyViewHolder>() {
    var items = ArrayList<RecyclerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row_mvvm, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setListData(data: ArrayList<RecyclerData>) {
        this.items = data
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageThumb = view.img_recylerview_item
        fun bind(data: RecyclerData) {
            Glide.with(imageThumb).load( data.owner.avatar_url).circleCrop().into(imageThumb)
        }
    }
}