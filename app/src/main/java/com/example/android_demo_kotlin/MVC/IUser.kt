package com.example.android_demo_kotlin.MVC

interface IUser {

    fun getEmail(): String?
    fun getPassword(): String?
    fun isValid(): Int
}