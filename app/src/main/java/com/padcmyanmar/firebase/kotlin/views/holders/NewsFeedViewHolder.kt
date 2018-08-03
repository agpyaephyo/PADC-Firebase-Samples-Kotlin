package com.padcmyanmar.firebase.kotlin.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.firebase.kotlin.R
import com.padcmyanmar.firebase.kotlin.data.vo.NewsFeedVO
import kotlinx.android.synthetic.main.view_holder_news_feed.view.*

class NewsFeedViewHolder(itemView: View) : BaseViewHolder<NewsFeedVO>(itemView) {

    override fun bind(data: NewsFeedVO) {
        itemView.tvUsername.text = data.newsAuthor!!.userName
        //itemView.tvPostedDate.text = itemView.context.getString(R.string.tv_format_posted_date, data.posedDate)
        itemView.tvFeedMsg.text = data.content
        itemView.tvTotalReactions.text = itemView.context.getString(R.string.format_total_reactions,
                data.likes!!.size,
                data.comments!!.size,
                data.sendToCount)

        Glide.with(itemView.context)
                .load(data.image)
                .into(itemView.ivFeedImage)

        Glide.with(itemView.context)
                .load(data.newsAuthor.profileImage)
                .into(itemView.ivProfile)
    }

    override fun onClick(view: View) {

    }
}