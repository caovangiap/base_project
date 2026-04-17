package com.example.baseapp.main.groupdata

import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.baseapp.main.adapter.BaseRclvAdapter
import com.example.baseapp.main.adapter.BaseRclvHolder

class GroupRcvAdapter : BaseRclvAdapter() {

    var groupManager: GroupManager
        protected set

    init {
        groupManager = GroupManager()
    }


    override fun getItemCount(): Int {
        return groupManager.getItemCount()
    }

    override fun getItemViewType(position: Int): Int {
        return groupManager.getItemViewType(position)
    }

    override fun getLayoutItem(viewType: Int): Int {
        return groupManager.getLayoutItem(viewType)
    }

    override fun onCreateVH(
        itemView: View,
        viewType: Int
    ): BaseRclvHolder<*, *> {
        return groupManager.onCreateVH(itemView,viewType)
    }

    override fun onBindViewHolder(holder: BaseRclvHolder<ViewBinding, Any>, position: Int) {
        if (holder is GroupRclvVH<*, *, *>) {
            groupManager.onBindViewHolder((holder as GroupRclvVH<*, Any, GroupData<*>>), position)
        } else {
            super.onBindViewHolder(holder, position)
        }
    }

    override fun getItemDataAtPosition(position: Int): Any {
        return groupManager.getItemDataAtAdapterPosition(position)
    }

    fun addGroup(group: GroupData<*>?){
        group?.let { groupManager.addGroupData(it) }
    }

}