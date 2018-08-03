package com.padcmyanmar.firebase.kotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.padcmyanmar.firebase.kotlin.views.holders.BaseViewHolder
import java.util.ArrayList

abstract class BaseRecyclerAdapter<T : BaseViewHolder<W>, W>(context: Context) : RecyclerView.Adapter<T>() {

    protected var mLayoutInflater: LayoutInflater = LayoutInflater.from(context)

    internal var mData: MutableList<W> = ArrayList()

    init {
        mData = ArrayList()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewData(newData: MutableList<W>) {
        mData = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<W>) {
        mData.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): W? {
        return if (position < mData.size - 1) mData[position] else null

    }

    fun removeData(data: W) {
        mData.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: W) {
        mData.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mData = ArrayList()
        notifyDataSetChanged()
    }

    fun getAllItems(): List<W> {
        return mData
    }
}