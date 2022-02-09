package com.example.android_demo_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.People

class RecyclerviewGridAdapter(
    private var peopleList: ArrayList<People>
) :
    RecyclerView.Adapter<RecyclerviewGridAdapter.RecyclerviewgridViewHolder>() {
    private var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewgridViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.gridlayout_recyclerview_item_layout, parent, false)
        return RecyclerviewgridViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerviewgridViewHolder, position: Int) {
        val person = peopleList[position]
        holder.imgView?.setImageResource(person.image)
        holder.txtname?.text = person.name
    }
    override fun getItemCount(): Int {
        return peopleList.count()
    }
    class RecyclerviewgridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView? = itemView.findViewById(R.id.recylerview_grid_img)
        val txtname: TextView? = itemView.findViewById(R.id.txtview_name_recyclerview_grid)
    }

}
