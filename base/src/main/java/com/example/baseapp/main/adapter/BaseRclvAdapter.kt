package com.example.baseapp.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRclvAdapter : RecyclerView.Adapter<BaseRclvHolder<ViewBinding, Any>>() {

    private val dataSet: MutableList<Any> = ArrayList<Any>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRclvHolder<ViewBinding, Any> {
        val layoutRes = getLayoutItem(viewType)
        val viewHolder = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return onCreateVH(viewHolder,viewType) as BaseRclvHolder<ViewBinding, Any>
    }

    override fun onBindViewHolder(
        holder: BaseRclvHolder<ViewBinding, Any>,
        position: Int
    ) {
        holder.onBind(getItemDataAtPosition(position))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    protected open fun getItemDataAtPosition(position: Int): Any {
        return dataSet[position]
    }

    abstract fun getLayoutItem(viewType: Int): Int
    abstract fun onCreateVH(itemView: View, viewType: Int): BaseRclvHolder<*, *>
}