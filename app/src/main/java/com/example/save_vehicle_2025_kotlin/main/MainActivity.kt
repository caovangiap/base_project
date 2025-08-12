package com.example.save_vehicle_2025_kotlin.main

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.airbnb.lottie.LottieDrawable
import com.example.save_vehicle_2025_kotlin.R
import com.example.save_vehicle_2025_kotlin.base.ui.BaseActivity
import com.example.save_vehicle_2025_kotlin.databinding.MainActivityBinding
import com.example.save_vehicle_2025_kotlin.main.navigation.BaseNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    private lateinit var binding : MainActivityBinding
    override fun getViewBinding(): MainActivityBinding {
        binding = MainActivityBinding.inflate(layoutInflater)
        return binding
    }

    override fun initView() {

    }

    override fun onResume() {
        super.onResume()

    }

    override fun listenStateView() {
//        showLoading()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}