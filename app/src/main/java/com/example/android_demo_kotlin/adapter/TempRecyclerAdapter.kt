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
    lateinit var binding : RecyclerviewItemLayoutBinding
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempRecyclerAdapter.tempViewHolder {
        context = parent.context
        binding =  RecyclerviewItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return TempRecyclerAdapter.tempViewHolder(binding)
    }
    override fun onBindViewHolder(holder: tempViewHolder, position: Int) {
        binding.dataModel = imageList[position]
    }

    override fun getItemCount(): Int {
      return  imageList.size
    }

    class tempViewHolder(val binding: RecyclerviewItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    }


}