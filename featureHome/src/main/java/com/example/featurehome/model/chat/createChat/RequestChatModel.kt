package com.prodigy.feature.girlfriend.model.chat.createChat

import com.google.gson.annotations.SerializedName

data class RequestChatModel(
    @SerializedName("characterId")
    var characterId: Int,
    @SerializedName("characterType")
    var characterType: String,
    @SerializedName("cursor")
    var cursor : Int?,
    @SerializedName("limit")
    var limit : Int?
)