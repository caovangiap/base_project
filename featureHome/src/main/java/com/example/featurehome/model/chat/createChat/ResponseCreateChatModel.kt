package com.prodigy.feature.girlfriend.model.chat.createChat

import com.google.gson.annotations.SerializedName

data class ResponseCreateChatModel(
    @SerializedName("chat")
    val chat: ChatIdModel,
    @SerializedName("history")
    val history: HistoryCreateChatModel
)