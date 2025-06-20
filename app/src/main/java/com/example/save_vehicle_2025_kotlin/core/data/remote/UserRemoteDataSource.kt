package com.example.save_vehicle_2025_kotlin.core.data.remote

import com.example.save_vehicle_2025_kotlin.core.data.LoginResponse
import com.example.save_vehicle_2025_kotlin.core.network.NetworkResult
import com.example.save_vehicle_2025_kotlin.core.network.safeApiCall
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val userApiService: UserApiService
) {
    suspend fun getUserProfile(): NetworkResult<LoginResponse> {
        return safeApiCall { userApiService.getUserProfile() }
    }
}