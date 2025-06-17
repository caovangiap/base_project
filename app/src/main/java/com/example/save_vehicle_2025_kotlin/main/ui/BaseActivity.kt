package com.example.save_vehicle_2025_kotlin.main.ui

import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.airbnb.lottie.LottieAnimationView
import com.example.save_vehicle_2025_kotlin.R
import com.example.save_vehicle_2025_kotlin.databinding.BaseActivityBinding

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    private lateinit var viewBinding : VB
    abstract fun getViewBinding(): VB
    abstract fun initView()
    abstract fun listenStateView()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getViewBinding()
        setContentView(viewBinding.root)
        initView()
        listenStateView()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }


    fun showLoading() {
        viewBinding.root.findViewById<LottieAnimationView>(R.id.icLoading).apply {
            visibility = View.VISIBLE
            playAnimation()
        }
    }


    fun dismissLoading() {
        viewBinding.root.findViewById<LottieAnimationView>(R.id.icLoading).apply {
            visibility = View.GONE
            pauseAnimation()
        }
    }

}
