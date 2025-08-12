package com.example.save_vehicle_2025_kotlin.base.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.airbnb.lottie.LottieAnimationView
import com.example.save_vehicle_2025_kotlin.R
import com.example.save_vehicle_2025_kotlin.main.navigation.BaseNavigation
import timber.log.Timber

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity(),BaseNavigation {

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

    override fun openScreen(@IdRes action: Int) {
        this.findNavController(R.id.nav_host).navigate(action)
    }

}
