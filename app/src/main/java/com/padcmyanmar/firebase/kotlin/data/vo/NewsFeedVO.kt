package com.padcmyanmar.firebase.kotlin.data.vo

import com.google.gson.annotations.SerializedName

class NewsFeedVO {

    @SerializedName("feed_id")
    val feedId: Long = 0

    @SerializedName("posted_date")
    val posedDate: Long = 0

    @SerializedName("content")
    val content: String? = null

    @SerializedName("image")
    val image: String? = null

    @SerializedName("send_to")
    val sendToCount: Int = 0

    @SerializedName("news_author")
    val newsAuthor: NewsAuthorVO? = null

    @SerializedName("likes")
    val likes: List<LikeVO>? = null

    @SerializedName("comments")
    val comments: List<CommentVO>? = null
}