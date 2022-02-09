package com.example.android_demo_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.AppDemo

class ExpandableRecyclerAdapter(val AppList: ArrayList<AppDemo>) :
    RecyclerView.Adapter<ExpandableRecyclerAdapter.ExpandableViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandableViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_expandable, parent, false)
        return ExpandableViewHolder(view)
    }
    override fun onBindViewHolder(holder: ExpandableViewHolder, position: Int) {
        holder.apply {
            nameTxt.text = AppList[position].namehello
            dateTxt.text = AppList[position].date
            apiTxt.text = AppList[position].apilevel
            descriptionTxt.text = AppList[position].description
            expendableLayout.visibility =
                if (AppList[position].expandable) View.VISIBLE else View.GONE
            linearLayout.setOnClickListener {
                val version = AppList[position]
                version.expandable = !AppList[position].expandable
                notifyItemChanged(position)
            }
        }
    }
    override fun getItemCount(): Int {
        return AppList.count()
    }
    class ExpandableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTxt: TextView = itemView.findViewById(R.id.txt_name)
        var dateTxt: TextView = itemView.findViewById(R.id.txt_date)
        var apiTxt: TextView = itemView.findViewById(R.id.txt_api)
        var descriptionTxt: TextView = itemView.findViewById(R.id.description)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)
        var expendableLayout: RelativeLayout = itemView.findViewById(R.id.expandable_layout)

    }
}