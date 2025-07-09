package com.example.save_vehicle_2025_kotlin.base.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.airbnb.lottie.LottieAnimationView
import com.example.save_vehicle_2025_kotlin.R
import timber.log.Timber

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    private lateinit var viewBinding : VB
    abstract fun getViewBinding(): VB
    abstract fun initView()
    abstract fun listenStateView()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getViewBinding()
        setContentView(viewBinding.root)

    }

    override fun onStart() {
        super.onStart()
        initView()
        listenStateView()
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
