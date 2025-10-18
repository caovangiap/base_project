package com.example.featurehome

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.baseapp.base.ui.BaseFragment
import com.example.featurehome.databinding.FragmentSecondBinding
import com.example.featurehome.databinding.WelcomeFragmentBinding
import com.example.featurehome.ui.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class SecondFragment : BaseFragment<WelcomeFragmentBinding, HomeViewModel>() {


    private val binding : WelcomeFragmentBinding by lazy { WelcomeFragmentBinding.inflate(layoutInflater) }
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getViewBinding(): WelcomeFragmentBinding {
        return binding
    }

    override fun initView() {

    }

    override fun listenStateView() {

    }

    override fun viewModelForBase(): HomeViewModel {
        return viewModel
    }

    override fun setOnClick() {
    }

}