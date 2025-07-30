package com.example.core.core.data.repository

import com.example.core.core.data.LoginResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserProfile(): Flow<Result<LoginResponse>>
}