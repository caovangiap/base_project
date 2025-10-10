package com.prodigy.feature.girlfriend.model.getToken

import com.google.gson.annotations.SerializedName


data class JwtTokenRequest(
    @SerializedName("device_id")
    val deviceId : String,
    @SerializedName("package_name")
    val packageName : String,
    @SerializedName("signature")
    val signature : String,
    @SerializedName("firebase_token")
    val firebaseToken : String,
    @SerializedName("os")
    val  os : String,
    @SerializedName("country")
    val country : String,
    @SerializedName("social_token")
    val  socialToken : String ? =null,
    @SerializedName("login_type")
    val  loginType : String? = null,
    @SerializedName("name_service")
    val  nameService : String,
    @SerializedName("app_code")
    val  appCode : String,
)
