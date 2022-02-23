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

class RecyclerViewAdapter(private var peopleList: ArrayList<People>, private val itemClickCallBack: (Any) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerviewViewHolder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_layout, parent, false)
        return RecyclerviewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerviewViewHolder, position: Int) {
        val person = peopleList[position]
        holder.apply {
            setIsRecyclable(false)
            imgView?.setImageResource(person.image)
            txtname?.text = person.name
            checkbx?.apply {
                isChecked = person.check
                setOnCheckedChangeListener { _, check ->
                    person.check = check
                    itemClickCallBack(check)
                }
            }
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