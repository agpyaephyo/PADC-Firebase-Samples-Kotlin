package com.padcmyanmar.firebase.kotlin.components.rvset

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View
import com.padcmyanmar.firebase.kotlin.R

class DividerItemDecoration(private val mContext: Context) : RecyclerView.ItemDecoration() {

    private val mDivider: Drawable?

    init {
        val a = mContext.obtainStyledAttributes(ATTRS)
        mDivider = a.getDrawable(0)
        a.recycle()
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val resources = mContext.resources
        val bottomSpacing = resources.getDimension(R.dimen.list_item_bottom_spacing).toInt()
        val rightSpacing = resources.getDimension(R.dimen.list_item_right_spacing).toInt()
        outRect.set(0, bottomSpacing, 0, bottomSpacing)

        /*
        SmartRecyclerView sRv = (SmartRecyclerView) parent;
        int spanCount = sRv.getSpanCount();

        int position = parent.getChildAdapterPosition(view);
        if ((position + 1) % spanCount == 0) {
            outRect.set(0, 0, 0, bottomSpacing);
        } else {
            outRect.set(0, 0, rightSpacing, bottomSpacing);
        }
        */
    }

    companion object {

        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }
}