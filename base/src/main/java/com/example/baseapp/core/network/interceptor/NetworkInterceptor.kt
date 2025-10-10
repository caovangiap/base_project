package com.example.baseapp.core.network.interceptor

import android.content.Context
import com.example.baseapp.base.utils.ConstantValue
import com.example.baseapp.base.utils.isNetworkConnected
import com.example.baseapp.base.utils.RxPreferences
import com.example.baseapp.core.events.TokenRefreshEvent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    @ApplicationContext private val context: Context,
    private val rxPreferences: RxPreferences,
    private val tokenRefreshEvent: TokenRefreshEvent
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        // Thêm headers nếu có JVM token
        val jvmToken = rxPreferences.getJvmToken()
        if (!jvmToken.isNullOrEmpty() && jvmToken != ConstantValue.NOT_REFRESH_TOKEN) {
            request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer $jvmToken")
                .build()
        }
        Timber.tag("NetworkInterceptor").i("jvmToken $jvmToken")

        if (!context.isNetworkConnected(context)) {
            Timber.tag("NetworkInterceptor").e("no inter net")
            throw IOException("No network connection")
        } else {
            try {
                val bufferRequest = okio.Buffer()
                request.body?.writeTo(bufferRequest)
                Timber.tag("NetworkInterceptor").i("curl -X ${request.method} ${request.url} -d '${bufferRequest.readUtf8()}'")
                val response = chain.proceed(request)
                val responseBody = response.body
                val source = responseBody?.source()
                source?.request(Long.MAX_VALUE)
                val buffer = source?.buffer
                //response body chỉ có thể đọc 1 lần -> clone body
                val responseBodyString = buffer?.clone()?.readString(Charset.forName("UTF-8"))
                Timber.tag("NetworkInterceptor").e("responseBodyString\", \"body: $responseBodyString")
                when (response.code) {
                    200 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("success 200 : $response")
                    }

                    400 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 400 :Dữ liệu đầu vào không hợp lệ hoặc thiếu thông tin bắt buộc. (vd: Remove Object nhưng truyền vào ảnh trang giấy trắng)")
                    }

                    401 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Unauthorized 401 :Không có quyền truy cập vào tài nguyên yêu cầu, sai lỗi hết hạn token")
                        refreshToken()
                    }

                    403 ->{
                        Timber.tag("NetworkInterceptor")
                            .i("Forbidden 403 :Truy cập bị cấm, dù đã xác thực.")
                    }
                    404 ->{
                        Timber.tag("NetworkInterceptor")
                            .i("Not Found 404 :Tài nguyên yêu cầu không tồn tại, không trả về ảnh sex, ảnh người nổi tiếng.")
                    }
                    405 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Method Not Allowed 405 :Phương thức HTTP không được phép trên endpoint này")
                    }
                    408 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Request Timeout 408 : Yêu cầu mất quá nhiều thời gian để xử lý. (quá 60 giây)")
                    }

                    422 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Unprocessable Entity 422 : Dữ liệu đầu vào hợp lệ về mặt cú pháp nhưng không thể xử lý hoặc không tìm thấy ảnh trả về")
                    }

                    429 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Too Many Requests 429 : Quá nhiều yêu cầu trong một khoảng thời gian ngắn. (server bị quá tải trong 1 khoảng thời gian)")
                    }

                    500 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Internal Server Error 500 : Lỗi máy chủ nội bộ (bên Amazon - nơi thuê máy chủ)")
                    }

                    502 ->{
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Gateway 502 : Máy chủ đang đóng vai trò cổng hoặc proxy nhận được phản hồi không hợp lệ từ máy chủ khác. (bên Amazon - nơi thuê máy chủ)")
                    }

                    503 ->{
                        Timber.tag("NetworkInterceptor")
                            .i("Service Unavailable 503 : Dịch vụ tạm thời không khả dụng. (API Amobear bị dead)")
                    }

                    410 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 410 : Ảnh chứa nội dung 18+ (ảnh sex). Photos containing sensitive (18+) content!")
                    }

                    411 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 411 : Không phát hiện có mặt người trong ảnh. Face not detected")
                    }

                    412 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 412 : Không phát hiện đối tượng nào trong ảnh. Object recognition failed")
                    }

                    413 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 413 : Không phát hiện ra đoạn văn bản nào trong ảnh. No detect text")
                    }

                    414 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 414 : Không phát hiện ra bầu trời nào trong ảnh. No detect sky")
                    }

                    415 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 415 : AI không lấy được ảnh gốc từ S3. Failed AI get root img from S3")
                    }

                    416 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 416 : AI không đẩy được ảnh đã xử lý lên S3. Failed AI upload result img to S3")
                    }

                    417 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 417 : Sai định dạng ảnh, chỉ cho phép jpg, jpeg, png")
                    }

                    418 -> {
                        Timber.tag("NetworkInterceptor")
                            .i("Bad Request 418 : Từ khóa (prompt) không hợp lệ. Lọc prompt không hợp lệ theo từ khóa trong sheet Backlist prompt")
                    }

                }
                return response
            } catch (e: Exception) {
                Timber.tag("NetworkInterceptor")
                    .i("Bad Request : exception $e")
            }
            return chain.proceed(request)
        }
    }


    private fun refreshToken(){
        rxPreferences.setRefreshToken(ConstantValue.REFRESH_TOKEN)
        Timber.tag("NetworkInterceptor").i("Triggering token refresh event...")
        CoroutineScope(Dispatchers.IO).launch {
            tokenRefreshEvent.triggerRefreshToken()
        }
    }
}
