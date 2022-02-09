package com.example.android_demo_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.People

class ViewPagerRecyclerAdapter(private var peopleList: ArrayList<People>) :
    RecyclerView.Adapter<ViewPagerRecyclerAdapter.ViewpagerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewpagerHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewpager_recyclerview, parent, false)
        return ViewpagerHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewpagerHolder, position: Int) {
        val person = peopleList[position]
        holder.imgView?.setImageResource(person.image)
        holder.txtname?.text = person.name
    }
    override fun getItemCount(): Int {
        return peopleList.count()
    }
    class ViewpagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView? = itemView.findViewById(R.id.recylerview_grid_img)
        val txtname: TextView? = itemView.findViewById(R.id.txtview_name_recyclerview_grid)
    }
}