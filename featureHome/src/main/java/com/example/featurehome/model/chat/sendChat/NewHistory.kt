package com.prodigy.feature.girlfriend.model.chat.sendChat

import com.google.gson.annotations.SerializedName

data class NewHistory(
    @SerializedName("content")
    val content: String,
    @SerializedName("role")
    val role: String
)