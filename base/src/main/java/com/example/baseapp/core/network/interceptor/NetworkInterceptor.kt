package com.example.baseapp.core.network.interceptor

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.baseapp.core.network.ApiException
import com.example.baseapp.base.utils.isNetworkConnected
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException
import timber.log.Timber
import java.nio.charset.Charset
import javax.inject.Inject

/**
 * bước can thiệp mọi request/response trước – sau khi Retrofit đã tạo URL và chuẩn bị gửi đi.
 */
class NetworkInterceptor @Inject constructor(
    private val context: Context,
    private val gson: Gson,
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

                    }
                    2019 ->{

                    }
                    else -> {
                        when (errorResponse.code) {
                            2003 -> {

                            }
                            else -> {

                            }
                        }
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
}
