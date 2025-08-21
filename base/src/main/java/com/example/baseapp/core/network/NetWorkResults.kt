package com.example.baseapp.core.network

import retrofit2.HttpException
import java.io.IOException


// khai bao out vi cho phep Nothing là subtype của T o error
// chi co the lay ra gia tri khi khai bao bang out khong the set gia tri
sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val exception: Throwable) : NetworkResult<Nothing>()
}


suspend fun <T> safeApiCall(call: suspend () -> T): NetworkResult<T> {
    return try {
        NetworkResult.Success(call())
    } catch (e: HttpException) {
        NetworkResult.Error(e)
    } catch (e: IOException) {
        NetworkResult.Error(e)
    } catch (e: Exception) {
        NetworkResult.Error(e)
    }
}