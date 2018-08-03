package com.padcmyanmar.firebase.kotlin.data.vo

import com.google.gson.annotations.SerializedName

class NewsAuthorVO {

    @SerializedName("user_id")
    val userId: Long = 0

    @SerializedName("user_name")
    val userName: String? = null

    @SerializedName("profile_image")
    val profileImage: String? = null
}