package com.example.core.core.data.repository

import com.example.core.core.data.LoginResponse
import com.example.core.core.data.remote.UserRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
) : UserRepository {
    override suspend fun getUserProfile(): Flow<Result<LoginResponse>> = flow {

        try {
            val result = remoteDataSource.getUserProfile()
//            if (result.successCall()){
                emit(Result.success(result))
//            }else{
//                Timber.tag("UserRepositoryImpl").e("getUserProfile: ${result.code}")
//            }
            Timber.tag("UserRepositoryImpl").e("getUserProfile: $result")
        }catch (e : Exception){
            emit(Result.failure(e))
            Timber.tag("UserRepositoryImpl").e("Exception: $e")
        }

    }
}