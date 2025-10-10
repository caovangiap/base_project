package com.prodigy.feature.girlfriend.model.chat.reponseChatList

import com.google.gson.annotations.SerializedName

data class PaginationChatList(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)