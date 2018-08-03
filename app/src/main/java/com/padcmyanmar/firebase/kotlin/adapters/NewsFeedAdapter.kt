package com.padcmyanmar.firebase.kotlin.adapters

import android.content.Context
import android.view.ViewGroup
import com.padcmyanmar.firebase.kotlin.R
import com.padcmyanmar.firebase.kotlin.data.vo.NewsFeedVO
import com.padcmyanmar.firebase.kotlin.views.holders.NewsFeedViewHolder

class NewsFeedsAdapter(context: Context) : BaseRecyclerAdapter<NewsFeedViewHolder, NewsFeedVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFeedViewHolder {
        val view = mLayoutInflater.inflate(R.layout.view_holder_news_feed, parent, false)
        return NewsFeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsFeedViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 16
    }
}