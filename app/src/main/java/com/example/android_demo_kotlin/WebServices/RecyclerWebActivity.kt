package com.example.android_demo_kotlin.WebServices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.adapter.RecyclerviewApiAdapter
import com.example.android_demo_kotlin.model.PersonList
import com.example.android_demo_kotlin.model.PersonWeb
import com.example.android_demo_kotlin.utils.APPICATION_ACCEPT
import com.example.android_demo_kotlin.utils.APPLICATION_DATA_TYPE
import com.example.android_demo_kotlin.utils.BASE_URL
import com.example.android_demo_kotlin.utils.GET
import com.example.android_demo_kotlin.utils.USERID_KEY
import com.example.android_demo_kotlin.utils.USER_LIST_API
import com.google.gson.GsonBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.android.synthetic.main.activity_recycler_web.floating_btn_add
import kotlinx.android.synthetic.main.activity_recycler_web.recyclerview_progressbar
import kotlinx.android.synthetic.main.activity_recycler_web.recylerview_web
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class RecyclerWebActivity : AppCompatActivity() {

    private lateinit var personData: PersonWeb
    private lateinit var usersArray: ArrayList<PersonList>
    val userlist : ArrayList<PersonList> = ArrayList<PersonList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_web)
        recyclerview_progressbar.visibility = View.VISIBLE
        floating_btn_add.setOnClickListener {
            val intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)
        }
        getMethod()
    }

    private fun getMethod() {
        GlobalScope.launch(Dispatchers.IO) {
            val url = URL(BASE_URL + USER_LIST_API)
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.apply {
                setRequestProperty(APPICATION_ACCEPT, APPLICATION_DATA_TYPE)
                requestMethod = GET
                doInput = true
                doOutput = false
            }
            val responseCode = httpURLConnection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = httpURLConnection.inputStream.bufferedReader().use { it.readText() }
                withContext(Dispatchers.Main) {
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val jsonObject = JSONObject(response)
                    val jsonArray = jsonObject.getJSONArray("data")

                    for (position in 0..(jsonArray.length())-1){
                        userlist.add(PersonList(email = jsonArray.getJSONObject(position).getString("email")))
                    }
                    recyclerview_progressbar.visibility = View.GONE
                    setAdapter()
                }
            } else {
                Log.e("HTTPURLCONNECTION_ERROR", responseCode.toString())
            }
        }
    }

    private fun setAdapter() {
        val adapter = RecyclerviewApiAdapter(this,userlist) {
            val intent = Intent(this, SingleUserActivity::class.java)
            intent.putExtra(USERID_KEY, it.toString())
            startActivity(intent)
        }
        recylerview_web.adapter = adapter
    }
}