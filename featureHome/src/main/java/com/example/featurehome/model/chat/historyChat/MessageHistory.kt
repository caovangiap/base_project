package com.prodigy.feature.girlfriend.model.chat.historyChat

import com.google.gson.annotations.SerializedName

data class MessageHistory(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("message")
    val message: String,
    @SerializedName("sender")
    val sender: String? = null
)