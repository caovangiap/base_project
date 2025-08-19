package com.example.save_vehicle_2025_kotlin.core.data.repository

import com.example.save_vehicle_2025_kotlin.core.data.LoginResponse
import com.example.save_vehicle_2025_kotlin.core.data.apis.UserRemoteDataSource
import com.example.save_vehicle_2025_kotlin.core.network.NetworkResult
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
) : UserRepository {
    override suspend fun getUserProfile(): NetworkResult<LoginResponse> {

        return when (val result = remoteDataSource.getUserProfile()) {
            is NetworkResult.Success -> {

                NetworkResult.Success(result.data)
            }
            is NetworkResult.Error -> NetworkResult.Error(result.exception)
        }
    }
}