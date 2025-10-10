package com.prodigy.feature.girlfriend.model.chat.createChat

import com.google.gson.annotations.SerializedName

data class MessageCreateChatModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("sender")
    val sender: String
)