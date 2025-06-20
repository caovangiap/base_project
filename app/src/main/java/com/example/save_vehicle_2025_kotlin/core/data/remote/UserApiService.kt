package com.example.save_vehicle_2025_kotlin.core.data.remote

import com.example.save_vehicle_2025_kotlin.core.data.LoginResponse
import retrofit2.http.GET

interface UserApiService {
    @GET("user/profile")
    suspend fun getUserProfile(): LoginResponse
}