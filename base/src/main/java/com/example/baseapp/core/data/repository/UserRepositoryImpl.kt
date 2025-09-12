package com.example.baseapp.core.data.repository

import com.example.baseapp.core.data.LoginResponse
import com.example.baseapp.core.data.remote.UserRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.baseapp.core.data.BaseResults
import javax.inject.Inject
import com.example.baseapp.core.data.ApiResult

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
) : UserRepository {
    
    override suspend fun getUserProfile(): Flow<ApiResult<BaseResults<LoginResponse>>> = flow {
        // Emit loading state trước
        emit(ApiResult.Loading)
        
        val result = remoteDataSource.getUserProfile()
        when(result){
            is ApiResult.Success -> {
                if (result.data.successCall()){
                    // Business logic success
                    emit(ApiResult.Success(result.data))
                } else {
                    // Business logic error
                    emit(ApiResult.Error(
                        Exception("Business Error"), 
                        "API returned error code: ${result.data.code}"
                    ))
                }
            }
            is ApiResult.Error -> {

                emit(result)
            }
            is ApiResult.Loading -> {

                emit(result)
            }
        }
    }
}