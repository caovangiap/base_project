package com.prodigy.feature.girlfriend.model.chat.sendChat

import com.google.gson.annotations.SerializedName

data class SendChatRequestModel(
    @SerializedName("chatId")
    val chatId: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("tier")
    val tier: String,
    @SerializedName("gift")
    val gift : String = "",
    @SerializedName("level")
    val level: String = "1"
)