package com.prodigy.feature.girlfriend.model.refreshToken

import com.example.baseapp.base.utils.ConstantValue.NAME_SERVICE_DEFAULT
import com.google.gson.annotations.SerializedName


data class RefreshTokenRequest(
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("name_service")
    val nameService: String = NAME_SERVICE_DEFAULT,
)
