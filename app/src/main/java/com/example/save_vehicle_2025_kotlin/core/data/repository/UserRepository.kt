package com.example.save_vehicle_2025_kotlin.core.data.repository

import com.example.save_vehicle_2025_kotlin.core.data.LoginResponse
import com.example.save_vehicle_2025_kotlin.core.network.NetworkResult

interface UserRepository {
    suspend fun getUserProfile(): NetworkResult<LoginResponse>
}