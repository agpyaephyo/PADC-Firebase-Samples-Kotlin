package com.padcmyanmar.firebase.kotlin.events

import com.padcmyanmar.firebase.kotlin.data.vo.NewsFeedVO

class FirebaseEvents {

    class NewsFeedLoadedEvent(val newsFeed: List<NewsFeedVO>)
}