package com.example.save_vehicle_2025_kotlin.main

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.Lifecycle
import com.example.baseapp.base.ui.BaseActivity
import com.example.baseapp.base.ui.UiState
import com.example.baseapp.main.MainViewModel
import com.example.save_vehicle_2025_kotlin.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    private lateinit var binding : MainActivityBinding
    private lateinit var viewModel: MainViewModel
    override fun getViewBinding(): MainActivityBinding {
        binding = MainActivityBinding.inflate(layoutInflater)
        return binding
    }

    override fun initView() {
        viewModel.getUserProfile()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun listenStateView() {
        // Collect UI state từ ViewModel
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
                            // Initial state - do nothing
                        }
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun showLoading() {
        // TODO: Implement loading UI
        // Ví dụ: binding.progressBar.visibility = View.VISIBLE
        // binding.loadingText.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        // TODO: Hide loading UI
        // Ví dụ: binding.progressBar.visibility = View.GONE
        // binding.loadingText.visibility = View.GONE
    }

    private fun showContent(data: com.example.baseapp.core.data.BaseResults<com.example.baseapp.core.data.LoginResponse>) {
        // TODO: Implement success UI
        // Ví dụ: binding.textView.text = data.data?.token ?: "No token"
        // binding.userInfo.visibility = View.VISIBLE
    }

    private fun hideContent() {
        // TODO: Hide content UI
        // Ví dụ: binding.userInfo.visibility = View.GONE
    }

    private fun showError(message: String) {
        // TODO: Implement error UI
        // Ví dụ: binding.errorText.text = message
        // binding.errorText.visibility = View.VISIBLE
    }

    private fun hideError() {

    }
}