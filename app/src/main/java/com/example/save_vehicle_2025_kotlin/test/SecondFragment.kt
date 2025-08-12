package com.example.save_vehicle_2025_kotlin.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.save_vehicle_2025_kotlin.R
import com.example.save_vehicle_2025_kotlin.base.ui.BaseFragment
import com.example.save_vehicle_2025_kotlin.databinding.FragmentFirstBinding
import com.example.save_vehicle_2025_kotlin.databinding.FragmentSecondBinding
import com.example.save_vehicle_2025_kotlin.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding, MainViewModel>() {


    private val binding : FragmentSecondBinding by lazy { FragmentSecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getViewBinding(): FragmentSecondBinding {
        return binding
    }

    override fun initView() {

    }

    override fun listenStateView() {

    }

}