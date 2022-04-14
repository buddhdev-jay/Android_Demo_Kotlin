package com.example.android_demo_kotlin.MVP

import android.view.View

class Presenter(view: View) {
    private val user: User = User()
    private val view: View = view

    fun updateFullName(fullName: String?) {
        user.setFullName(fullName)
        view.updateUserInfoTextView(fullName.toString())
    }

    fun updateEmail(email: String?) {
        user.setEmail(email)
        view.updateUserInfoTextView(email.toString())
    }

    interface View {
        fun updateUserInfoTextView(info: String?)
    }
}