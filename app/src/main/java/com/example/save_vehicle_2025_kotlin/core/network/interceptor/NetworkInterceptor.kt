package com.example.save_vehicle_2025_kotlin.core.network.interceptor

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.save_vehicle_2025_kotlin.core.network.ApiException
import com.example.save_vehicle_2025_kotlin.base.utils.BuildConfig
import com.example.save_vehicle_2025_kotlin.base.utils.RxPreferences
import com.example.save_vehicle_2025_kotlin.base.utils.isNetworkConnected
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException
import timber.log.Timber
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import javax.inject.Inject

/**
 * bước can thiệp mọi request/response trước – sau khi Retrofit đã tạo URL và chuẩn bị gửi đi.
 */
class NetworkInterceptor @Inject constructor(
    private val context: Context,
    private val gson: Gson,
    private val rxPreferences: RxPreferences,

    ) : Interceptor {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (!context.isNetworkConnected(context)) {

            throw IOException("No network connection")
        } else {
            try {
                Timber.tag("NetworkInterceptor").e("NetworkInterceptor\", \"intercept: $request")
                for ((key, value) in request.headers) {
                    Timber.tag("NetworkInterceptor").e("NetworkInterceptor :Header Check:$key: $value")
                }
                val response = chain.proceed(request)
                val responseBody = response.body
                val source = responseBody?.source()
                source?.request(Long.MAX_VALUE)
                val buffer = source?.buffer
                val responseBodyString = buffer?.clone()?.readString(Charset.forName("UTF-8"))
                val errorResponse = gson.fromJson(responseBodyString, ApiException::class.java)
                when (response.code) {
                    in 200..299 -> {

                    }
                    400, 402, 403, 404, 405, 409 -> {
                        if (errorResponse.code == 2003) {
                            if (request.url.toString().endsWith("/login") || request.url.toString().endsWith("/otp/vhome")) {

                            }
                        } else {

                        }
                    }
                    2019 ->{
                    }
                    else -> {
                        when (errorResponse.code) {
                            2003 -> {}
                            else -> {
                            }
                        }
                    }

                }
                when (errorResponse.errorCode) {
                    800033 -> {
                    }
                }
                when (errorResponse.code) {
                    10001 -> {

                    }
                }
                return response
            } catch (e: Exception) {
                if ("Canceled" != e.message) {

                }
            }
            return chain.proceed(request)
        }
    }

    private fun refreshToken(): Boolean {
        val refreshUrl = URL("${BuildConfig.BASE_URL}/api/vhome/refresh/v6")
        val urlConnection = refreshUrl.openConnection() as HttpURLConnection
        urlConnection.apply {
            doInput = true
            setRequestProperty("RefreshToken", rxPreferences.getRefreshToken())
            requestMethod = "GET"
            useCaches = false
            connectTimeout = 10000
            readTimeout = 15000
        }
        return true
    }
}
