package com.prodigy.feature.girlfriend.model.chat.reponseChatList

import com.google.gson.annotations.SerializedName

data class DataChatList(
    @SerializedName("character_type")
    val characterType: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_link")
    val imageLink: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("last_message")
    val lastMessage: String?,
    @SerializedName("last_message_at")
    val lastMessageAt: String?,
    @SerializedName("last_sender")
    val lastSender: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("skins")
    val skins: List<String>,
    @SerializedName("videos")
    val videos: List<String>
)