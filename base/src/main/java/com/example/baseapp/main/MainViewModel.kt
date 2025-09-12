package com.example.baseapp.main

import androidx.lifecycle.viewModelScope
import com.example.baseapp.base.ui.BaseViewModel
import com.example.baseapp.base.ui.UiState
import com.example.baseapp.base.ui.UiState.*
import com.example.baseapp.core.data.BaseResults
import com.example.baseapp.core.data.LoginResponse
import com.example.baseapp.core.data.repository.UserRepository
import com.example.baseapp.core.data.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState<BaseResults<LoginResponse>>>(UiState.Idle)
    val uiStateCurrent: StateFlow<UiState<BaseResults<LoginResponse>>> = _uiState.asStateFlow()

    fun getUserProfile() {
        viewModelScope.launch {
            userRepository.getUserProfile()
                .catch { e -> 
                    _uiState.value = Error(e.message ?: "Unknown error")
                }
                .collect { result ->
                    when (result) {
                        is ApiResult.Loading -> {
                            _uiState.value = UiState.Loading
                        }
                        is ApiResult.Success -> {
                            _uiState.value = Success(result.data)
                        }
                        is ApiResult.Error -> {
                            _uiState.value = Error(result.message)
                        }

                    }
                }
        }
    }
}