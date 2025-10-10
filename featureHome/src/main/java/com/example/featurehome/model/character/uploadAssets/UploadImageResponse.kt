package com.prodigy.feature.girlfriend.model.character.uploadAssets

import okhttp3.ResponseBody

data class UploadImageResponse(
    val isSuccess: Boolean,
    val statusCode: Int,
    val response: retrofit2.Response<ResponseBody>
)
