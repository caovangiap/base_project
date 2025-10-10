package com.prodigy.feature.girlfriend.model.chat.sendChat

import com.google.gson.annotations.SerializedName

data class SendChatResponseModel(
    @SerializedName("_id")
    val id: String,
    @SerializedName("firebase_token")
    val firebaseToken: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("os")
    val os: String,
    @SerializedName("result")
    val result: Result,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("user_id")
    val userId: Int
)