package com.example.baseapp.main.groupdata

import android.view.View
import com.example.baseapp.main.adapter.BaseRclvHolder

open class GroupManager {

    private val dataSet: MutableList<GroupData<*>> = ArrayList()

    fun getItemCount(): Int {
        var total = 0
        for (data in dataSet) {
            if (data.isAttached) {
                total += data.getItemCount()
            }
        }
        return total
    }



    fun getItemViewType(adapterPosition: Int): Int {
        val data = findGroupDataByAdapterPosition(adapterPosition)
        return data?.getItemViewType(adapterPosition - data.attachAdapterPosition)
            ?: throw IllegalArgumentException("Can not find data for position: $adapterPosition")
    }


    fun findGroupDataByAdapterPosition(adapterPosition: Int): GroupData<*>? {
        for (data in dataSet) {
            if (data.isAttached) {
                if (data.attachAdapterPosition <= adapterPosition && adapterPosition < data.attachAdapterPosition + data.getItemCount()) {
                    return data
                }
            }
        }
        return null
    }

    fun getLayoutItem(viewType: Int): Int {
        for (data in dataSet) {
            val layoutRes = data.getLayoutItem(viewType)
            if (layoutRes != -1) {
                return layoutRes
            }
        }
        throw IllegalArgumentException("Can not find layout for type: $viewType")
    }

    fun onBindViewHolder(vh: GroupRclvVH<*, Any, GroupData<*>>, position: Int) {
        vh.groupData = findGroupDataByAdapterPosition(position)
        val vhData = getItemDataAtAdapterPosition(position)
        vh.onBind(vhData)
    }

    fun getItemDataAtAdapterPosition(adapterPosition: Int): Any {
        val data = findGroupDataByAdapterPosition(adapterPosition)
        return data?.getDataInGroup(adapterPosition - data.attachAdapterPosition)
            ?: throw IllegalArgumentException("Can not find data for position: $adapterPosition")
    }

    fun onCreateVH(itemView : View, viewType : Int) : BaseRclvHolder<*, *>{
        for (data in dataSet) {
            val vh: BaseRclvHolder<*, *>? = data.onCreateVH(itemView, viewType)
            if (vh != null) {
                return vh
            }
        }
        throw IllegalArgumentException("Can not find ViewHolder for type: $viewType")
    }

    fun addGroupData(group: GroupData<*>){
        group.setGroupManager(this)
        dataSet.add(group)
        if (group.getItemCount() == 0) {
            group.detach()
        } else if (!group.isAttached) {
            group.attach()
        }
    }
}