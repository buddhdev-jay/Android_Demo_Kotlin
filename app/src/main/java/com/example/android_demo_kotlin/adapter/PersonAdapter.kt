package com.example.android_demo_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.Person

class PersonAdapter(context: Context, val item: ArrayList<Person>) : BaseAdapter() {
    private var PersonList = arrayListOf<Person>()
    val layoutinflator = LayoutInflater.from(context)

    init {
        PersonList = item
    }

    override fun getCount(): Int {
        return PersonList.count()
    }

    override fun getItem(position: Int): Any {
        //Not yet implemented
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View? {
        val View: View? =  layoutinflator.inflate(R.layout.list_item_layout, parent, false)
        val viewholder: ListviewViewHolder = ListviewViewHolder(View)
        viewholder.apply {
            txtname?.text = PersonList[position].name
            txtaddress?.text = PersonList[position].address
            imgView?.setImageResource(PersonList[position].image)
        }
        return View
    }

    private class ListviewViewHolder(view: View?) {
        val imgView: ImageView? = view?.findViewById(R.id.listview_img)
        val txtname: TextView? = view?.findViewById(R.id.txtview_name_listview)
        val txtaddress: TextView? = view?.findViewById(R.id.txtview_address_listview)
    }

}