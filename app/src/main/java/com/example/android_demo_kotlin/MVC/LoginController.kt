package com.example.android_demo_kotlin.MVC

import User


class LoginController(var loginView: ILoginView) : ILoginController {

    override fun OnLogin(email: String, password: String) {
        val user = User(email, password)
        val loginCode: Int = user.isValid()
        if (loginCode == 0) {
            loginView.OnLoginError("Please enter Email")
        } else if (loginCode == 1) {
            loginView.OnLoginError("Please enter A valid Email")
        } else if (loginCode == 2) {
            loginView.OnLoginError("Please enter Password")
        } else {
            loginView.OnLoginSuccess("login Successful")
        }
    }
}
