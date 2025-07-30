package com.example.core.core.data.remote

import com.example.core.core.data.AuthRequest
import com.example.core.core.data.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRemoteDataSource @Inject constructor(
    private val userApiService: UserApiService
) {
    suspend fun getUserProfile(): LoginResponse {
        return userApiService.getUserProfile(AuthRequest("0986784498","12345678aB@","NPCH"))
    }
}