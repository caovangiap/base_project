package com.example.save_vehicle_2025_kotlin.main

import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.Glide
import com.example.baseapp.base.ui.BaseActivity
import com.example.baseapp.base.ui.LoadingCallback
import com.example.baseapp.base.ui.UiState
import com.example.baseapp.base.utils.RxPreferences
import com.example.baseapp.core.data.BaseResults
import com.example.baseapp.core.data.LoginResponse
import com.example.baseapp.core.di.GlobalNavigation
import com.example.baseapp.main.navigation.BaseNavigation
import com.example.featurehome.R
import com.example.save_vehicle_2025_kotlin.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>(), LoadingCallback {

    private lateinit var binding : MainActivityBinding

    private val viewModel: MainViewModel by viewModels()


    @Inject
    lateinit var rxPreferences: RxPreferences

    @Inject
    @GlobalNavigation
    lateinit var mainNav: BaseNavigation

    override fun getViewBinding(): MainActivityBinding {
        binding = MainActivityBinding.inflate(layoutInflater)
        return binding
    }

    override fun initView() {
        viewModel.listenForTokenRefresh()
        val navHostFragment = supportFragmentManager
            .findFragmentById(com.example.save_vehicle_2025_kotlin.R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        mainNav.attach(navController)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun listenStateView() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateCurrent.collect { state ->
                    when (state) {
                        is UiState.Loading -> {
                            showLoading()
                            hideError()
                            hideContent()
                        }
                        is UiState.Success -> {
                            hideLoading()
                            hideError()
                            showContent(state.data)
                        }
                        is UiState.Error -> {
                            hideLoading()
                            hideContent()
                            showError(state.message)
                        }
                        is UiState.Idle -> {

                        }
                    }
                }
            }
        }

        viewModel.isLoading.observe(this){ isLoading ->
            if (isLoading) {
                Glide.with(this)
                    .load(R.drawable.loading_gif)
                    .into(binding.loadingGif)
                binding.loading.visibility = View.VISIBLE
            }else{
                binding.loading.visibility = View.INVISIBLE
            }
        }
    }


    override fun showLoading() {
        viewModel.loading(true)
    }

    override fun hideLoading() {
        viewModel.loading(false)
    }

    private fun showContent(data: BaseResults<LoginResponse>) {

    }

    private fun hideContent() {

    }

    private fun showError(message: String) {

    }

    private fun hideError() {

    }


}