package com.example.android_demo_kotlin.MVP

class User {
    private var fullName = ""
    private var email = ""

    constructor() {}

    fun setFullName(fullName: String?) {
        if (fullName != null) {
            this.fullName = fullName
        }
    }

    fun setEmail(email: String?) {
        if (email!= null) {
            this.email = email
        }
    }
}