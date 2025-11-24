package com.example.baseapp.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

open class BaseRclvHolder<VB : ViewBinding, DATA>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val viewBinding: VB

    init {
        viewBinding = createBindingInstance(itemView)
    }

    /**
     * mục tiêu của hàm này là
     *      đang tạo ra 1 trừu tượng viewbinding
     *      nhưng chỉ cần mỗi khi sử dụng truyền vào itemview là tự có viewBinding chính xác dùng quá biến viewBinding trong class này
      */

    private fun createBindingInstance(itemView: View): VB {
        var genericSuperClass: Type? = javaClass.genericSuperclass
        var parametrizedType: ParameterizedType? = null
        while (parametrizedType == null) {
            if (genericSuperClass is ParameterizedType) {
                parametrizedType = genericSuperClass
            } else {
                genericSuperClass = (genericSuperClass as Class<*>).genericSuperclass
            }
        }
        val vbType = parametrizedType.actualTypeArguments[0]
        val vbClass = vbType as Class<VB>
        val method = vbClass.getMethod(
            "bind",
            View::class.java
        )

        // Call VB.inflate(inflater, container, false) Java static method
        return method.invoke(null, itemView) as VB
    }
    open fun onBind(vhData: DATA) {}
}

