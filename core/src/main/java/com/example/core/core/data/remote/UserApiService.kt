package com.example.core.core.data.remote

import com.example.core.core.data.AuthRequest
import com.example.core.core.data.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    @POST("/api/app/vhome/v4/login")
    suspend fun getUserProfile(@Body dataModel: AuthRequest?): LoginResponse
}