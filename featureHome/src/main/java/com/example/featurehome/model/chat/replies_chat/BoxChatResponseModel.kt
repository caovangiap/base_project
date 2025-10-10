package com.prodigy.feature.girlfriend.model.chat.replies_chat

import com.google.gson.annotations.SerializedName

data class BoxChatResponseModel(
    @SerializedName("_id")
    val Id: String,
    @SerializedName("firebase_token")
    val firebaseToken: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("os")
    val os: String,
    @SerializedName("result")
    val result: ResultBoxChat,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("user_id")
    val userId: Int
)