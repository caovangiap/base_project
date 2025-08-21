package com.example.baseapp.core.data.remote

import com.example.baseapp.core.data.LoginResponse
import com.example.baseapp.core.network.NetworkResult
import com.example.baseapp.core.network.safeApiCall
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val userApiService: UserApiService
) {
    suspend fun getUserProfile(): NetworkResult<LoginResponse> {
        return safeApiCall { userApiService.getUserProfile() }
    }
}