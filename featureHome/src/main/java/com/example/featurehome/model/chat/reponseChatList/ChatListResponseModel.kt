package com.prodigy.feature.girlfriend.model.chat.reponseChatList

import com.google.gson.annotations.SerializedName

data class ChatListResponseModel(
    @SerializedName("data")
    val data: List<DataChatList>,
    @SerializedName("pagination")
    val pagination: PaginationChatList
)