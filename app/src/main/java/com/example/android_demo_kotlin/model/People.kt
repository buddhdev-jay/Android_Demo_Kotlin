package com.example.android_demo_kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class People(var name: String,var check : Boolean, var image: Int): Parcelable {}