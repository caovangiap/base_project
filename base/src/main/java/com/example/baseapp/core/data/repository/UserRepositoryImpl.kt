package com.example.baseapp.core.data.repository

import com.example.baseapp.core.data.LoginResponse
import com.example.baseapp.core.data.remote.UserRemoteDataSource
import com.example.baseapp.core.network.NetworkResult
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