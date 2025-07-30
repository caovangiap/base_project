package com.example.save_vehicle_2025_kotlin.main

import androidx.lifecycle.viewModelScope
import com.example.core.base.ui.BaseViewModel
import com.example.core.core.data.repository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepositoryImpl
) : BaseViewModel() {

    fun getUserProfile() {
        viewModelScope.launch {
            userRepository.getUserProfile().collect { result ->
                result.onSuccess {
                    Timber.tag("MainViewModel").d("getUserProfile: $it")
                }.onFailure {
                    Timber.tag("MainViewModel").d("getUserProfile: ${it.message}")
                }
            }
        }
        Timber.tag("MainViewModel").d("getUserProfile")
    }
}