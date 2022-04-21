package com.example.android_demo_kotlin.mvvm.Retrofit

import com.example.android_demo_kotlin.utils.GITHUB_API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(GITHUB_API_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}