package com.example.core.core.network.interceptor

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.core.base.utils.ConstantValue
import com.example.core.base.utils.RxPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import timber.log.Timber
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject

/**
 * bước can thiệp mọi request/response trước – sau khi Retrofit đã tạo URL và chuẩn bị gửi đi.
 */
class NetworkInterceptor @Inject constructor(
    @ApplicationContext private val context: Context,
    private val rxPreferences: RxPreferences,

    ) : Interceptor {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request().newBuilder()
            .addHeader("AppKey", ConstantValue.APP_KEY)
            .addHeader("AppSecret",ConstantValue.APP_SECRET)
            .addHeader("Content-Type",ConstantValue.CONTENT_TYPE)
            .build()
        Timber.tag("NetworkInterceptor").d("Request URL: ${request.url}")
        // Log method (POST/GET)
        Timber.tag("NetworkInterceptor").d("Method: ${request.method}")
        // Có thể log header nếu cần
        Timber.tag("NetworkInterceptor").d("Headers: ${request.headers}")
        request.body?.let { body ->
            val buffer = Buffer()
            body.writeTo(buffer)
            Timber.d("Body: ${buffer.readUtf8()}")
        }


        // Log response body thô
        chain.proceed(request).body?.let { responseBody ->
            val source = responseBody.source()
            source.request(Long.MAX_VALUE) // Yêu cầu toàn bộ body
            val buffer = source.buffer
            val responseBodyString = buffer.clone().readUtf8()
            Timber.tag("NetworkInterceptor").d("Response Body: $responseBodyString")
        }
        return chain.proceed(request)
    }

    private fun refreshToken(): Boolean {
        val refreshUrl = URL("${ConstantValue.BASE_URL}/api/vhome/refresh/v6")
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
