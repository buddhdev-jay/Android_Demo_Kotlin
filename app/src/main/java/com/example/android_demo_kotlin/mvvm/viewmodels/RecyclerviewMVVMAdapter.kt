package com.example.android_demo_kotlin.mvvm.viewmodels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_demo_kotlin.mvvm.data.RecyclerData
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.recyclerview_row_mvvm.view.imgt_humb

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
        val imageThumb = view.imgt_humb

        fun bind(data: RecyclerData) {
            val url = data.owner.avatar_url
            Glide.with(imageThumb).load(url).circleCrop().into(imageThumb)
        }
    }
}