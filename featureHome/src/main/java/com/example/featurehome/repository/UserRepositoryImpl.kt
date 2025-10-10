package com.prodigy.feature.girlfriend.repository

import android.content.Context
import com.example.baseapp.base.utils.RxPreferences
import com.example.baseapp.core.data.ApiResult
import com.example.baseapp.core.data.JwtBaseToken
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import com.prodigy.feature.girlfriend.model.getToken.JwtTokenDecodeModel
import com.prodigy.feature.girlfriend.remote.GirlFriendRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val context: Context,
    private val remoteDataSource: GirlFriendRemoteDataSource,
    private val jwtTokenValue: JwtBaseToken,
    private val gson: Gson,
    private val rxPreferences: RxPreferences,

) : UserRepository {

    private inline fun <reified T> convertDataRequestToJson(dataRequest: T): String {
        return gson.toJson(dataRequest)
    }


    private fun getCountryCode(): String {
        val locale = context.resources.configuration.locale
        val countryCode = locale.country
        return countryCode
    }

    private inline fun <reified T> convertJsonToObject(json: String): T? {
        return try {
            val type = object : TypeToken<T>() {}.type
            gson.fromJson<T>(json, type)
        } catch (_: Exception) {
            null
        }
    }

    override suspend fun fetchToken(
        packageName: String,
        firebaseToken: String,
        tokenGoogle: String?
    ): Flow<ApiResult<JwtTokenDecodeModel>> = flow {
        emit(ApiResult.Loading)

    }.flowOn(Dispatchers.IO)

}