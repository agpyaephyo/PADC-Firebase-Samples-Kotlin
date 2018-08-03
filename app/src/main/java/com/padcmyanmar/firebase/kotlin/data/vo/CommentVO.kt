package com.padcmyanmar.firebase.kotlin.data.vo

import com.google.gson.annotations.SerializedName

class CommentVO {

    @SerializedName("comment_id")
    val commentId: Long = 0

    @SerializedName("user_id")
    val userId: Long = 0

    @SerializedName("comment")
    val comment: String? = null

    @SerializedName("timestamp")
    val timestamp: Long = 0
}