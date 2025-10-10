package com.prodigy.feature.girlfriend.model.character.uploadAssets

import okhttp3.RequestBody

data class UploadImageRequest(
    val uploadUrl: String,
    val imageFile: RequestBody
)
