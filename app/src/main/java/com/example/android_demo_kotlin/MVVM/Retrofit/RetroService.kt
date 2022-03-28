package com.example.android_demo_kotlin.MVVM.Retrofit

import com.example.android_demo_kotlin.MVVM.data.RecyclerList
import com.example.android_demo_kotlin.utils.REPOSITORIES
import com.example.android_demo_kotlin.utils.SEARCH_QUERY_VARIABLE
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET(REPOSITORIES)
    fun getDataFromAPI(@Query(SEARCH_QUERY_VARIABLE) query: String): Call<RecyclerList>
}