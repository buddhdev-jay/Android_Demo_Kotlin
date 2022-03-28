package com.example.android_demo_kotlin.WebServices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.UserInfo
import kotlinx.android.synthetic.main.activity_create_user.btn_create_user
import retrofit2.Callback
import kotlinx.android.synthetic.main.activity_create_user.editxt_createuser_job
import kotlinx.android.synthetic.main.activity_create_user.editxt_createuser_name
import retrofit2.Call
import retrofit2.Response

class CreateUserActivity : AppCompatActivity() {
    lateinit var retrofit: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        retrofit = ApiInterface.create()
        btn_create_user.setOnClickListener {
            if(TextUtils.isEmpty(editxt_createuser_name.text.toString())){
                Toast.makeText(this,getString(R.string.enter_name_toast),Toast.LENGTH_SHORT).show()
            }else if(TextUtils.isEmpty(editxt_createuser_job.text.toString())){
                Toast.makeText(this,getString(R.string.enter_job_toast),Toast.LENGTH_SHORT).show()
            }else{
                val user = UserInfo(editxt_createuser_job.text.toString(),editxt_createuser_name.text.toString())
                retrofit.addUser(user).enqueue(object :Callback<UserInfo>{
                    override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                        Log.d("Response","Suceess")
                    }
                    override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                        // Will be Implemented Later
                    }
                })
            }

        }


    }
}