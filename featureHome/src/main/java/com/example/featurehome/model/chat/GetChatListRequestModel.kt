package com.prodigy.feature.girlfriend.model.chat

import com.google.gson.annotations.SerializedName

data class GetChatListRequestModel(
    @SerializedName("limit")
    var limit: Int,
    @SerializedName("page")
    var page: Int
)