package com.example.save_vehicle_2025_kotlin.main

import android.os.Bundle
import com.example.save_vehicle_2025_kotlin.R
import com.example.save_vehicle_2025_kotlin.base.ui.BaseActivity
import com.example.save_vehicle_2025_kotlin.databinding.BaseActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<BaseActivityBinding, MainViewModel>() {

    private lateinit var binding : BaseActivityBinding
    override fun getViewBinding(): BaseActivityBinding {
        binding = BaseActivityBinding.inflate(layoutInflater)
        return binding
    }

    override fun initView() {

    }

    override fun listenStateView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}