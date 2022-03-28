package com.example.android_demo_kotlin.model

import com.google.gson.annotations.SerializedName

data class SingleUserData (
    @SerializedName("data")
    val data: PersonList?,
    @SerializedName("support")
    val support: Support?
)
