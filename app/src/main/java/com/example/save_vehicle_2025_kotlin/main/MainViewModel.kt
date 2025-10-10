package com.example.save_vehicle_2025_kotlin.main

import androidx.lifecycle.viewModelScope
import com.example.baseapp.base.ui.BaseViewModel
import com.example.baseapp.base.ui.UiState
import com.example.baseapp.base.utils.ConstantValue
import com.example.baseapp.base.utils.RxPreferences
import com.example.baseapp.core.data.ApiResult
import com.example.baseapp.core.data.BaseResults
import com.example.baseapp.core.data.LoginResponse
import com.example.baseapp.core.events.TokenRefreshEvent
import com.prodigy.feature.girlfriend.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val rxPreferences: RxPreferences,
    private val tokenRefreshEvent: TokenRefreshEvent
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState<BaseResults<LoginResponse>>>(UiState.Idle)
    val uiStateCurrent: StateFlow<UiState<BaseResults<LoginResponse>>> = _uiState.asStateFlow()

    fun listenForTokenRefresh() {
        viewModelScope.launch {
            tokenRefreshEvent.refreshTokenEvent.collect {
                Timber.tag("MainViewModel").i("Received token refresh event, calling fetchToken...")
                try {
                    viewModelScope.launch {
                        userRepository.refreshToken()
                            .collect { result ->
                                when (result) {
                                    is ApiResult.Loading -> {
                                        Timber.d("fetchToken Loading")
                                    }
                                    is ApiResult.Success -> {
                                        Timber.d("fetchToken Success ${result.data}")
                                        rxPreferences.setJvmToken(result.data.refreshToken)
                                    }
                                    is ApiResult.Error -> {
                                        Timber.d("fetchToken Error ${result.message}")
                                    }
                                }
                            }
                    }
                } finally {
                    tokenRefreshEvent.markRefreshComplete()
                }
            }
        }
    }
}