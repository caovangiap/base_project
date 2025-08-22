package com.example.save_vehicle_2025_kotlin.main

import android.os.Bundle
import com.example.baseapp.base.ui.BaseActivity
import com.example.baseapp.main.MainViewModel
import com.example.save_vehicle_2025_kotlin.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

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