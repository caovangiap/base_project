package com.example.baseapp.main.groupdata

import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.baseapp.main.adapter.BaseRclvHolder

abstract class GroupRclvVH<VB: ViewBinding, T, GD : GroupData<*>>(itemView: View) : BaseRclvHolder<VB, T>(itemView) {


}