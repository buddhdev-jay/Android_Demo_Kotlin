package com.example.android_demo_kotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class PersonWeb(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("per_page")
    var perPage: Int? = null,
    @SerializedName("total")
    var total: Int? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("data")
    var usersList: ArrayList<PersonList> = arrayListOf(),
    @SerializedName("support")
    var support: Support? = Support()
    )
@Parcelize
data class PersonList(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("first_name")
    var firstName: String? = null,
    @SerializedName("last_name")
    var lastName: String? = null,
    @SerializedName("avatar")
    var avatar: String? = null
): Parcelable
data class Support(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("text")
    var text: String? = null
)