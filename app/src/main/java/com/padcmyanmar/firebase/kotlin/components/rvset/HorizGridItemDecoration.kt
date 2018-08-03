package com.padcmyanmar.firebase.kotlin.components.rvset

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View
import com.padcmyanmar.firebase.kotlin.R

class HorizGridItemDecoration(private val mContext: Context) : RecyclerView.ItemDecoration() {

    private val mDivider: Drawable?

    init {
        val a = mContext.obtainStyledAttributes(ATTRS)
        mDivider = a.getDrawable(0)
        a.recycle()
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val resources = mContext.resources
        val marginMedium = resources.getDimension(R.dimen.margin_small).toInt()
        outRect.set(0, 0, marginMedium, 0)

        /*
        SmartRecyclerView sRv = (SmartRecyclerView) parent;
        int spanCount = sRv.getSpanCount();

        int position = parent.getChildAdapterPosition(view);
        if ((position + 1) % spanCount == 0) {
            outRect.set(0, 0, 0, marginMedium);
        } else {
            outRect.set(0, 0, marginMedium, marginMedium);
        }
        */
    }

    companion object {

        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }
}