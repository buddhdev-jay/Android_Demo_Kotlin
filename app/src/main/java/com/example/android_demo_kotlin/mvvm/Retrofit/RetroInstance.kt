package com.example.android_demo_kotlin.mvvm.Retrofit

import com.example.android_demo_kotlin.WebServices.ApiInterface
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {
        private var interceptor = OkHttpProfilerInterceptor()
        private val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor(interceptor)
            .addInterceptor(
                Interceptor {
                    val builder = it.request().newBuilder()
                    builder.header("Content-Type", "application/json")
                    return@Interceptor it.proceed(builder.build())
                }
            )
        private val okHttpClient = okHttpClientBuilder.build()
        val baseURL = "https://api.github.com/search/"
        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
    }
}