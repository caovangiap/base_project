package com.prodigy.feature.girlfriend.model.getToken

import androidx.lifecycle.LiveData
import com.google.gson.annotations.SerializedName

data class JwtTokenDecodeModel (
    @SerializedName("access_token")
    val accessToken: String?,
    @SerializedName("refresh_token")
    val refreshToken: String?,
    @SerializedName("time")
    val time: Long?,
    @SerializedName("user_info")
    val userInfo: UserInfo?
)