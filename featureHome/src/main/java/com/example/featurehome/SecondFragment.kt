package com.example.featurehome

import android.os.Bundle
import com.example.baseapp.MainViewModel
import com.example.baseapp.base.ui.BaseFragment
import com.example.navigation.databinding.FragmentSecondBinding
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