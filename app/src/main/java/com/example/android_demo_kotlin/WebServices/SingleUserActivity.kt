package com.example.android_demo_kotlin.WebServices

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.SingleUserData
import com.squareup.picasso.Picasso
import java.net.URL
import kotlinx.android.synthetic.main.activity_single_user.single_user_img
import kotlinx.android.synthetic.main.activity_single_user.txt_singleuser_email
import kotlinx.android.synthetic.main.activity_single_user.txt_singleuser_fname
import kotlinx.android.synthetic.main.activity_single_user.txt_singleuser_lname
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SingleUserActivity : AppCompatActivity() {
    lateinit var retrofit: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_user)
        retrofit = ApiInterface.create()
        intent.getStringExtra("UserId")?.let { userdata ->
            retrofit.getUser(userdata.toInt()).enqueue(object : Callback<SingleUserData>{
                override fun onResponse(call: Call<SingleUserData>, response: Response<SingleUserData>) {
                    response.body()?.data?.let {
                        Picasso.get().load(it?.avatar).into(single_user_img)
                        txt_singleuser_email.text = it?.email
                        txt_singleuser_fname.text = it?.firstName
                        txt_singleuser_lname.text = it?.lastName
                    }
                }
                override fun onFailure(call: Call<SingleUserData>, t: Throwable) {
                   // Will be Implemented Later
                }

            })
        }
    }
}