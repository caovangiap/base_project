package com.example.baseapp.core.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code")
    val code: Int,

    @SerializedName("token")
    val token: String?,

    @SerializedName("ezToken")
    val ezToken: String?,

    @SerializedName("refreshToken")
    val refreshToken: String?,

    @SerializedName("errorCode")
    val errorCode: Int? = null,

    @SerializedName("message")
    val message: String? = null
)