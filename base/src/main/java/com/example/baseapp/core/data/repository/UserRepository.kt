package com.example.baseapp.core.data.repository

import com.example.baseapp.core.data.ApiResult
import com.example.baseapp.core.data.BaseResults
import com.example.baseapp.core.data.LoginResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserProfile(): Flow<ApiResult<BaseResults<LoginResponse>>>
}