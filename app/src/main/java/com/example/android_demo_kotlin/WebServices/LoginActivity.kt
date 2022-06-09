package com.example.android_demo_kotlin.WebServices

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_demo_kotlin.MainActivity
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.utils.BASE_URL
import com.example.android_demo_kotlin.utils.RESPONSE_CODE_FAIL
import com.example.android_demo_kotlin.utils.RESPONSE_CODE_SUCESS
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_login.editxt_email_login
import kotlinx.android.synthetic.main.activity_login.editxt_password_login
import kotlinx.android.synthetic.main.activity_login.progressbar_login
import org.json.JSONObject
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        AppCenter.start(
            application, "f83e1a90-2b0f-486e-b7f1-4597ab0070ae",
            Analytics::class.java, Crashes::class.java
        )
        val prefs = getSharedPreferences(getString(R.string.sharedpref_name), Context.MODE_PRIVATE)
       if(prefs.getBoolean(getString(R.string.login_state),false)){
           intent = Intent(applicationContext, MainActivity::class.java)
           startActivity(intent)
           finish()
       }
        var isLogged = false
        btn_login.setOnClickListener {
            when {
                TextUtils.isEmpty(editxt_email_login.text.toString()) -> {
                    Toast.makeText(this, getString(R.string.enter_email_toast), Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(editxt_password_login.text.toString()) -> {
                    Toast.makeText(this, getString(R.string.enter_password_toast), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    progressbar_login.visibility = View.VISIBLE
                    Thread {
                        try {
                            val result = sendPostRequest(
                                editxt_email_login.text.toString(),
                                editxt_password_login.text.toString()
                            )
                            if (result) {
                                intent = Intent(applicationContext, MainActivity::class.java)
                                startActivity(intent)
                                isLogged = true
                                val editor = prefs.edit()
                                editor.putBoolean(getString(R.string.login_state), isLogged)
                                editor.apply()
                                finish()
                            } else {
                                runOnUiThread {
                                    Toast.makeText(applicationContext, getString(R.string.Invalid_login_toast), Toast.LENGTH_SHORT).show()
                                }
                            }
                        } catch (ex: Exception) {
                            ex.printStackTrace()
                        }
                    }.start()
                }
            }
        }
    }

    private fun sendPostRequest(email: String, password: String):Boolean{
        val cred = JSONObject()
        cred.put(getString(R.string.email_key_json), email)
        cred.put(getString(R.string.password_key_json), password)
        val url = URL(BASE_URL + getString(R.string.url_api_login))
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = getString(R.string.request_method)
            setRequestProperty(getString(R.string.json_content_type), getString(R.string.content_type_json))
            val writer = OutputStreamWriter(outputStream)
            writer.write(cred.toString())
            writer.flush()
            println("URL : $url")
            println("cred: $cred")
            println("Response Code: $responseCode")
            if (responseCode == RESPONSE_CODE_SUCESS) {
                runOnUiThread {
                    progressbar_login.visibility = View.GONE
                }
                return true
            } else if (responseCode == RESPONSE_CODE_FAIL) {
                return false
            }
            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                println("Response : $response")
            }
        }
        return false
    }
}