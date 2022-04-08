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
import com.example.android_demo_kotlin.model.People

class TempRecyclerAdapter(private var imageList: ArrayList<ImageUrlList>) :
    RecyclerView.Adapter<TempRecyclerAdapter.tempViewHolder>() {
    private var context: Context? = null
    val binding =

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempRecyclerAdapter.tempViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_layout, parent, false)
        return TempRecyclerAdapter.tempViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: tempViewHolder, position: Int) {
        val imageitem = imageList[position]
        holder.apply {
            imgView?.setImageResource(imageitem.imageurl)
            txtname?.text = imageitem
            checkbx?.apply {
                isChecked = person.check
            }
        }
    }

    override fun getItemCount(): Int {
      return  imageList.size
    }

    class tempViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView? = itemView.findViewById(R.id.recylerview_img)
        val txtname: TextView? = itemView.findViewById(R.id.txtview_name_recyclerview)
        val checkbx: CheckBox? = itemView.findViewById(R.id.chcx_recylerview)
    }


}