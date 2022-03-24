package com.example.android_demo_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import com.example.android_demo_kotlin.utils.GOOGLE_LOGIN
import com.example.android_demo_kotlin.utils.GOOGLE_SIGNUP
import com.example.android_demo_kotlin.utils.GOOGLE_URL
import kotlinx.android.synthetic.main.activity_webview.btn_login_webview
import kotlinx.android.synthetic.main.activity_webview.btn_signup_webview
import kotlinx.android.synthetic.main.activity_webview.web_view

class WebviewActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        web_view.webChromeClient = WebChromeClient()
        web_view.apply {
            loadUrl(GOOGLE_URL)
            settings.apply {
                javaScriptEnabled = true
                safeBrowsingEnabled = true
            }
        }
        btn_login_webview.setOnClickListener {
            web_view.loadUrl(GOOGLE_LOGIN)
        }
        btn_signup_webview.setOnClickListener {
            web_view.loadUrl(GOOGLE_SIGNUP)
        }
    }

    override fun onBackPressed() {
        if (web_view.canGoBack()){
            web_view.goBack()
        }else {
            super.onBackPressed()
        }
    }
}