package com.prodigy.feature.girlfriend.model.chat.createChat

import com.google.gson.annotations.SerializedName

data class HistoryCreateChatModel(
    @SerializedName("hasMore")
    val hasMore: Boolean,
    @SerializedName("messages")
    val messages: List<MessageCreateChatModel>,
    @SerializedName("nextCursor")
    val nextCursor: Int?
)