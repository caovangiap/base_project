package com.prodigy.feature.girlfriend.model.chat.historyChat

import com.google.gson.annotations.SerializedName

data class HistoryChatResponse(
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("messages")
    val messages: List<MessageHistory>,
    @SerializedName("next_cursor")
    val nextCursor: Int
)