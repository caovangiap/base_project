package com.prodigy.feature.girlfriend.model.chat.replies_chat

import com.google.gson.annotations.SerializedName

data class ResultBoxChat(
    @SerializedName("character_id")
    val characterId: String,
    @SerializedName("new_history")
    val newHistory: List<NewHistory>,
    @SerializedName("replies")
    val replies: List<String>,
    @SerializedName("user_id")
    val userId: Int
)