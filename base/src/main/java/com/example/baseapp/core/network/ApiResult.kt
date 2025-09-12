package com.example.baseapp.core.network

import retrofit2.HttpException
import java.io.IOException

/**
 * Sealed class để xử lý kết quả API calls
 */
sealed class ApiResult<out T> {
    object Loading : ApiResult<Nothing>()
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Throwable, val message: String) : ApiResult<Nothing>()
}

/**
 * Safe API call wrapper để xử lý exceptions
 */
suspend fun <T> safeApiCall(call: suspend () -> T): ApiResult<T> {
    return try {
        ApiResult.Success(call())
    } catch (e: HttpException) {
        ApiResult.Error(e, "HTTP Error: ${e.code()}")
    } catch (e: IOException) {
        ApiResult.Error(e, "Network Error: ${e.message}")
    } catch (e: Exception) {
        ApiResult.Error(e, "Unknown Error: ${e.message}")
    }
}