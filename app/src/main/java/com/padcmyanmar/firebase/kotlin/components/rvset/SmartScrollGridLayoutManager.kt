package com.padcmyanmar.firebase.kotlin.components.rvset

import android.content.Context
import android.graphics.PointF
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearSmoothScroller
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.DisplayMetrics

class SmoothScrollGridLayoutManager : GridLayoutManager {

    private var mLinearSmoothScroller: LinearSmoothScroller? = null

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        initLinearSmoothScroller(context)
    }

    constructor(context: Context, spanCount: Int) : super(context, spanCount) {
        initLinearSmoothScroller(context)
    }

    constructor(context: Context, spanCount: Int, orientation: Int, reverseLayout: Boolean) : super(context, spanCount, orientation, reverseLayout) {
        initLinearSmoothScroller(context)
    }

    override fun smoothScrollToPosition(recyclerView: RecyclerView, state: RecyclerView.State?, position: Int) {
        //super.smoothScrollToPosition(recyclerView, state, position);

        mLinearSmoothScroller!!.targetPosition = position
        startSmoothScroll(mLinearSmoothScroller)
    }

    private fun initLinearSmoothScroller(context: Context) {
        mLinearSmoothScroller = object : LinearSmoothScroller(context) {
            private val MILLISECONDS_PER_INCH = 100f

            override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
                //return super.computeScrollVectorForPosition(targetPosition);
                return this@SmoothScrollGridLayoutManager
                        .computeScrollVectorForPosition(targetPosition)
            }

            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                //return super.calculateSpeedPerPixel(displayMetrics);
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi
            }
        }
    }
}