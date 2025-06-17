package com.example.save_vehicle_2025_kotlin.main.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.save_vehicle_2025_kotlin.main.utils.isNetworkConnected

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    private lateinit var viewBinding : VB
    abstract fun getViewBinding(): VB
    abstract fun initView()
    abstract fun listenStateView()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = getViewBinding()
        initView()
        listenStateView()
        return viewBinding.root
    }

    fun showToast(context: Context, message: String) {
        showToast(requireContext(),"hello")
    }


    fun isNetworkConnected(): Boolean {
        if (activity is BaseActivity<*, *>) {
            return requireContext().isNetworkConnected(requireContext())
        }
        return false
    }

}