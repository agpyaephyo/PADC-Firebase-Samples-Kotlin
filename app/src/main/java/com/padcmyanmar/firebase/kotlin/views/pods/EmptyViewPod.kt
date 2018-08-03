package com.padcmyanmar.firebase.kotlin.views.pods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_pod_empty.view.*

class EmptyViewPod : RelativeLayout {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setEmptyLabel(emptyLabel: String) {
        lblEmpty.text = emptyLabel
    }

    fun setEmptyLabel(emptyLabel: String, textColor: Int) {
        lblEmpty.text = emptyLabel
        lblEmpty.setTextColor(textColor)
    }

    fun setEmptyAction(emptyAction: String, delegate: EmptyActionDelegate) {
        btnActionForEmpty.visibility = View.VISIBLE
        btnActionForEmpty.text = emptyAction
        btnActionForEmpty.setOnClickListener(delegate)
    }

    fun setEmptyImage(resourceId: Int) {
        ivEmpty.setImageResource(resourceId)
    }

    interface EmptyActionDelegate : View.OnClickListener
}