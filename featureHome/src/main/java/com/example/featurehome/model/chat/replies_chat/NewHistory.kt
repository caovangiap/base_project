package com.prodigy.feature.girlfriend.model.chat.replies_chat

import com.google.gson.annotations.SerializedName

data class NewHistory(
    @SerializedName("content")
    val content: String,
    @SerializedName("role")
    val role: String
)