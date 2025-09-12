package com.example.baseapp.core.data

import retrofit2.HttpException
import java.io.IOException

/**
 * Sealed class để xử lý kết quả API calls
 */
sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Throwable, val message: String) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}

/**
 * Safe API call wrapper để xử lý exceptions
 */
suspend fun <T> safeApiCall(call: suspend () -> T): ApiResult<T> {
    return try {
        ApiResult.Success(call())
    } catch (e: HttpException) {
        ApiResult.Error(e, "safeApiCall: HTTP Error -- ${e.code()}")
    } catch (e: IOException) {
        ApiResult.Error(e, "safeApiCall: NetWork Error -- ${e.message}")
    } catch (e: Exception) {
        ApiResult.Error(e, "safeApiCall: Exception Error -- ${e.message}")
    }
}