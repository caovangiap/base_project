package com.example.baseapp.core.data.repository

import com.example.baseapp.core.data.LoginResponse
import com.example.baseapp.core.network.NetworkResult

interface UserRepository {
    suspend fun getUserProfile(): NetworkResult<LoginResponse>
}