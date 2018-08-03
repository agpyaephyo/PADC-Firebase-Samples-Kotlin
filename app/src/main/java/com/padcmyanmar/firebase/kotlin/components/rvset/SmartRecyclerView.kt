package com.padcmyanmar.firebase.kotlin.components.rvset

import android.content.Context
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.View

class SmartRecyclerView : RecyclerView {

    private lateinit var mLayoutManager: SmoothScrollGridLayoutManager
    private var mEmptyView: View? = null
    var spanCount = 1
        private set
    private lateinit var mDividerItemDecoration: DividerItemDecoration
    private lateinit var mHorizGridItemDecoration: HorizGridItemDecoration
    private var mContextMenuInfo: RecyclerViewContextMenuInfo? = null

    private val dataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
            checkIfEmpty()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            checkIfEmpty()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            checkIfEmpty()
        }
    }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init(context, attrs)
    }

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(dataObserver)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(dataObserver)
        checkIfEmpty()
    }

    fun setEmptyView(view: View) {
        mEmptyView = view
        checkIfEmpty()
    }

    fun setupGridLayoutManager(spanCount: Int, isHorizontal: Boolean) {
        this.spanCount = spanCount
        if (!isHorizontal) {
            mLayoutManager = SmoothScrollGridLayoutManager(context, spanCount) //
            removeAllItemDecorations()
            addItemDecoration(mDividerItemDecoration)
        } else {
            mLayoutManager = SmoothScrollGridLayoutManager(context, spanCount, GridLayoutManager.HORIZONTAL, false)
            removeAllItemDecorations()
            addItemDecoration(mHorizGridItemDecoration)
        }
        layoutManager = mLayoutManager
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        setHasFixedSize(true)
        mDividerItemDecoration = DividerItemDecoration(getContext())
        mHorizGridItemDecoration = HorizGridItemDecoration(getContext())

        //addItemDecoration(mDividerItemDecoration);

        mLayoutManager = SmoothScrollGridLayoutManager(getContext(), spanCount) //
        layoutManager = mLayoutManager

        itemAnimator = DefaultItemAnimator()
    }

    private fun checkIfEmpty() {
        if (mEmptyView != null && adapter != null) {
            val isEmpty = adapter.itemCount == 0
            mEmptyView!!.visibility = if (isEmpty) View.VISIBLE else View.GONE
            visibility = if (isEmpty) View.GONE else View.VISIBLE
        }
    }

    private fun removeAllItemDecorations() {
        removeItemDecoration(mHorizGridItemDecoration)
        removeItemDecoration(mDividerItemDecoration)
    }

    override fun showContextMenuForChild(originalView: View): Boolean {
        val longPressPosition = getChildPosition(originalView)
        if (longPressPosition >= 0) {
            val longPressId = adapter.getItemId(longPressPosition)
            mContextMenuInfo = RecyclerViewContextMenuInfo(longPressPosition, longPressId)
            //This check doesn't require API-19.
            if (isAttachedToWindow) {
                return super.showContextMenuForChild(originalView)
            }
        }
        return false
    }

    override fun getContextMenuInfo(): ContextMenu.ContextMenuInfo? {
        return mContextMenuInfo
    }

    class RecyclerViewContextMenuInfo(val position: Int, val id: Long) : ContextMenu.ContextMenuInfo
}