package com.padcmyanmar.firebase.kotlin.views.holders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun bind(data: T)
}