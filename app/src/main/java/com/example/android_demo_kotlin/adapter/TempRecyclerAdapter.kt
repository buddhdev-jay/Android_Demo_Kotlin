package com.example.android_demo_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.databinding.ImageUrlList
import com.example.android_demo_kotlin.databinding.RecyclerviewItemLayoutBinding
import com.example.android_demo_kotlin.model.People

class TempRecyclerAdapter(private var imageList: ArrayList<ImageUrlList>) :
    RecyclerView.Adapter<TempRecyclerAdapter.tempViewHolder>() {
    private var context: Context? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempRecyclerAdapter.tempViewHolder {
        context = parent.context
        val binding =  RecyclerviewItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return TempRecyclerAdapter.tempViewHolder(binding)
    }
    override fun onBindViewHolder(holder: tempViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
      return  imageList.size
    }

    class tempViewHolder(val binding: RecyclerviewItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item:ImageUrlList){
            binding.txtviewNameRecyclerview.text = item.count.toString()
        }
        val imgView: ImageView? = itemView.findViewById(R.id.recylerview_img)
        val txtname: TextView? = itemView.findViewById(R.id.txtview_name_recyclerview)
        val checkbx: CheckBox? = itemView.findViewById(R.id.chcx_recylerview)
    }


}