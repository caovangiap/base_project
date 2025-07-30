package com.example.core.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    private lateinit var viewBinding : VB
    abstract fun getViewBinding(): VB
    abstract fun initView()
    abstract fun listenStateView()
    abstract fun viewModelState()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getViewBinding()
        setContentView(viewBinding.root)

    }

    override fun onStart() {
        super.onStart()
        initView()
        listenStateView()
        viewModelState()
    }

    override fun onPause() {
        super.onPause()
    }


//    fun showLoading() {
//        viewBinding.root.findViewById<LottieAnimationView>(R.id.icLoading).apply {
//            visibility = View.VISIBLE
//            playAnimation()
//        }
//        Timber.tag("test loading").e("showLoading")
//    }
//
//
//    fun hideLoading() {
//        viewBinding.root.findViewById<LottieAnimationView>(R.id.icLoading).apply {
//            visibility = View.GONE
//            pauseAnimation()
//        }
//        Timber.tag("test loading").e("hideLoading")
//    }

}
