package com.example.android_demo_kotlin.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.PersonList
import com.example.android_demo_kotlin.model.PersonWeb
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecyclerviewApiAdapter(private val context: Context,
                             private val usersList: ArrayList<PersonList>, private val itemClickCallBack: (Any) -> Unit):
    RecyclerView.Adapter<RecyclerviewApiAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageOfUser: ImageView = view.findViewById(R.id.img_recyclerview_api)
        val firstNameOfUser: TextView = view.findViewById(R.id.txt_firstname_recyclerview_api)
        val lastNameOfUser: TextView = view.findViewById(R.id.txt_lastname_recyclerview_api)
        val emailOfUser: TextView = view.findViewById(R.id.txt_email_recyclerview_api)
        val layout:ConstraintLayout = view.findViewById(R.id.recyclerweb_constraint)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recyclerviewapi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            GlobalScope.launch(Dispatchers.IO) {
                val url = usersList[position].avatar?.let {
                    URL(it)
            }
                val image = BitmapFactory.decodeStream(url?.openConnection()?.getInputStream())
                withContext(Dispatchers.Main) {
                    imageOfUser.setImageBitmap(image)
                    firstNameOfUser.text = usersList[position].firstName
                    lastNameOfUser.text = usersList[position].lastName
                    emailOfUser.text = usersList[position].email
                    layout.setOnClickListener {
                        usersList[position].id?.let { it1 -> itemClickCallBack(it1) }
                    }
                }

                }
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}