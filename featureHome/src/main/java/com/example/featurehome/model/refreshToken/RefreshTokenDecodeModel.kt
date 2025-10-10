package com.prodigy.feature.girlfriend.model.refreshToken

import com.google.gson.annotations.SerializedName


data class RefreshTokenDecodeModel(
    @SerializedName("access_token")
    val accessToken: String?,
    @SerializedName("refresh_token")
    val refreshToken: String?,
    @SerializedName("time")
    val time: Long?,
)
