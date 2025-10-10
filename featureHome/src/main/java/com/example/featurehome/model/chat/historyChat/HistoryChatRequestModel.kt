package com.prodigy.feature.girlfriend.model.chat.historyChat

import com.google.gson.annotations.SerializedName


data class HistoryChatRequestModel(
    @SerializedName("chatId")
    val chatId: Int,
    @SerializedName("cursor")
    var cursor: Int?,
    @SerializedName("limit")
    val limit: Int
)