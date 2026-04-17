package com.example.baseapp.main.groupdata

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.example.baseapp.main.adapter.BaseRclvHolder

/**
 * GroupData về bản chất như 1 abstract của adapter,
 * ý tưởng là mỗi lần override lại GroupData sẽ có 1 adapter để có thể add vào list các adapter được viết ở GroupRcvAdapter tạo thành danh sách các adapter
 */
abstract class GroupData<T> (val data: T)  {
    private var groupManager: GroupManager? = null
    fun setGroupManager(manager: GroupManager?) {
        groupManager = manager
    }
    open fun getItemViewType(): Int {
        return 0
    }
    abstract fun getLayoutItem(viewType: Int): Int

    abstract fun getDataInGroup(positionInGroup: Int): Any?
    abstract fun getItemCount(): Int
    abstract fun onCreateVH(itemView: View, viewType: Int): BaseRclvHolder<*, *>?
    abstract class GroupDiffUtilCallback<T>(
        private val oldDataList: List<T>, private val newDataList: List<T>
    ) : DiffUtil.Callback() {

        override fun getNewListSize(): Int {
            return newDataList.size
        }

        override fun getOldListSize(): Int {
            return oldDataList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return areContentsTheSame(oldDataList[oldItemPosition], newDataList[newItemPosition])
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return areItemsTheSame(oldDataList[oldItemPosition], newDataList[newItemPosition])
        }

        abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean
        abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean
    }
}