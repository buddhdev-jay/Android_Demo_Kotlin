package com.example.android_demo_kotlin.MVC

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.activity_mvcactivity.btn_login_mvc
import kotlinx.android.synthetic.main.activity_mvcactivity.edit_email_mvc
import kotlinx.android.synthetic.main.activity_mvcactivity.edit_password_mvc

class MVCActivity : AppCompatActivity(),ILoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        var loginPresenter: ILoginController
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvcactivity)
        loginPresenter = LoginController(this,applicationContext)
        btn_login_mvc.setOnClickListener {
            loginPresenter.OnLogin(edit_email_mvc.text.toString().trim(),edit_password_mvc.text.toString().trim())
        }
    }

    override fun OnLoginSuccess(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun OnLoginError(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}