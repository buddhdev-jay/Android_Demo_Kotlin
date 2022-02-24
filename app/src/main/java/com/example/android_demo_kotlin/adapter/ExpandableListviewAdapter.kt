package com.example.android_demo_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.utils.SIZE_LIST_ZERO

class ExpandableListviewAdapter(var context: Context, var headerList: MutableList<String>, var childList: HashMap<String, List<String>>) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return headerList.count()
    }

    override fun getChildrenCount(position: Int): Int {
        return this.childList[this.headerList[position]]?.count() ?: SIZE_LIST_ZERO
    }

    override fun getGroup(position: Int): String {
        return headerList[position]
    }

    override fun getChild(listPosition: Int, expandedListPosition: Int): String {
        return this.childList[this.headerList[listPosition]]?.get(expandedListPosition) ?: "0"
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View? {
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
            R.layout.item_listview_header, null).apply {
            val header = this?.findViewById<TextView>(R.id.txtview_expand_header)
            header?.text = getGroup(p0)
            return this
        }
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View? {
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
            R.layout.item_listview_child, null).apply {
            val header = this?.findViewById<TextView>(R.id.txtview_expand_child)
            header?.text = getChild(p0,p1)
            return this
        }
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}