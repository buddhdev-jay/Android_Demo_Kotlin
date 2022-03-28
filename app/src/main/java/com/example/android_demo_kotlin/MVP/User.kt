package com.example.android_demo_kotlin.MVP

class User {
    private var fullName = "jay"
    private var email = "dsvsf"

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