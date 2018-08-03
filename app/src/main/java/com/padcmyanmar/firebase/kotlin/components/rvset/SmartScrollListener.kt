package com.padcmyanmar.firebase.kotlin.components.rvset

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class SmartScrollListener(private val controller: ControllerSmartScroll) : RecyclerView.OnScrollListener() {

    private var visibleItemCount: Int = 0
    private var pastVisibleItems: Int = 0
    private var totalItemCount: Int = 0
    private var isListEndReached = false
    private var previousDy: Int = 0
    private var currentDy: Int = 0

    override fun onScrolled(rv: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(rv, dx, dy)

        currentDy = dy
        if (currentDy > previousDy) {
            //from top to bottom
        } else if (currentDy < previousDy) {
            //from bottom to top
            isListEndReached = false
        }

        visibleItemCount = rv!!.layoutManager.childCount
        totalItemCount = rv.layoutManager.itemCount
        pastVisibleItems = (rv.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

        previousDy = currentDy
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView?, scrollState: Int) {
        super.onScrollStateChanged(recyclerView, scrollState)
        if (scrollState == RecyclerView.SCROLL_STATE_IDLE) {
            if (visibleItemCount + pastVisibleItems >= totalItemCount && !isListEndReached) {
                isListEndReached = true
                controller.onListEndReached()
            }
        }
    }

    interface ControllerSmartScroll {
        fun onListEndReached()
    }
}