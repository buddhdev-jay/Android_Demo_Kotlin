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
import com.example.android_demo_kotlin.model.People

class RecyclerviewAdapter(
    private var peopleList: ArrayList<People>,
    private val itemClickCallBack: (Any) -> Unit
) :
    RecyclerView.Adapter<RecyclerviewAdapter.RecyclerviewViewHolder>() {
    private var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_layout, parent, false)
        return RecyclerviewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerviewViewHolder, position: Int) {
        val person = peopleList[position]
        holder.setIsRecyclable(false)
        holder.imgView?.setImageResource(person.image)
        holder.txtname?.text = person.name
        holder.checkbx?.isChecked = person.check
        holder.checkbx?.setOnCheckedChangeListener { _, check ->
            holder.checkbx.isChecked = check
            person.check = check
            itemClickCallBack(check)
        }
    }

    override fun getItemCount(): Int {
        return peopleList.count()
    }

    class RecyclerviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView? = itemView.findViewById(R.id.recylerview_img)
        val txtname: TextView? = itemView.findViewById(R.id.txtview_name_recyclerview)
        val checkbx: CheckBox? = itemView.findViewById(R.id.chcx_recylerview)
    }
}