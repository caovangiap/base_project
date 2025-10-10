package com.example.baseapp.base.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.baseapp.base.utils.isNetworkConnected

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    private lateinit var viewBinding : VB
    private lateinit var viewModel: VM
    private var loadingCallback: LoadingCallback? = null
    
    abstract fun getViewBinding(): VB
    abstract fun initView()
    abstract fun listenStateView()
    abstract fun viewModelForBase() : VM
    abstract fun setOnClick()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        listenStateView()
        setOnClick()
        viewModelForBase()
        viewModel.isLoading.observe(viewLifecycleOwner){
            loading(it)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is LoadingCallback) {
            loadingCallback = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        loadingCallback = null
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = getViewBinding()
        viewModel = viewModelForBase()
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

    fun loading(isLoading: Boolean) {
        if (isLoading) {
            loadingCallback?.showLoading()
        } else {
            loadingCallback?.hideLoading()
        }
    }

}