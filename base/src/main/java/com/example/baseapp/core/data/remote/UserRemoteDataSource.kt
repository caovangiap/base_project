package com.example.baseapp.core.data.remote

import com.example.baseapp.core.data.ApiResult
import com.example.baseapp.core.data.BaseResults
import com.example.baseapp.core.data.LoginResponse
import com.example.baseapp.core.data.safeApiCall
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val userApiService: UserApiService
) {
    suspend fun getUserProfile(): ApiResult<BaseResults<LoginResponse>> {
        return safeApiCall { userApiService.getUserProfile() }
    }
}