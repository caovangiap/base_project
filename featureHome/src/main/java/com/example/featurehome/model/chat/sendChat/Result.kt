package com.prodigy.feature.girlfriend.model.chat.sendChat

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("character_id")
    val characterId: String,
    @SerializedName("new_history")
    val newHistory: List<NewHistory>,
    @SerializedName("replies")
    val replies: List<String>,
    @SerializedName("user_id")
    val userId: Int
)