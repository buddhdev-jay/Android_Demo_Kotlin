package com.example.android_demo_kotlin.MVC

import User
import android.content.Context
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.utils.ONE
import com.example.android_demo_kotlin.utils.TWO
import com.example.android_demo_kotlin.utils.ZERO

class LoginController(var loginView: ILoginView,val applicationContext: Context) : ILoginController {
    
    override fun OnLogin(email: String, password: String) {
        val user = User(email, password)
        val loginCode: Int = user.isValid()
        when (loginCode) {
            ZERO -> {
                loginView.OnLoginError(applicationContext.getString(R.string.enter_email))
            }
            ONE -> {
                loginView.OnLoginError(applicationContext.getString(R.string.enter_valid_email))
            }
            TWO -> {
                loginView.OnLoginError(applicationContext.getString(R.string.enter_password))
            }
            else -> {
                loginView.OnLoginSuccess(applicationContext.getString(R.string.login_success))
            }
        }
    }
}
