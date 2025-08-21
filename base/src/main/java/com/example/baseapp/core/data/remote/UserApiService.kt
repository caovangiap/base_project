package com.example.baseapp.core.data.remote

import com.example.baseapp.core.data.LoginResponse
import retrofit2.http.GET

interface UserApiService {
    @GET("user/profile")
    suspend fun getUserProfile(): LoginResponse
}