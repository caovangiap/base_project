package com.example.save_vehicle_2025_kotlin.core.network

import com.google.gson.annotations.SerializedName

data class ApiException(
    @SerializedName("code")
    val code: Int = -1,

    @SerializedName("errorCode")
    val errorCode: Int? = null,

    @SerializedName("message")
    val message: String? = null,

    @SerializedName("details")
    val details: String? = null
)