package com.prodigy.feature.girlfriend.model.character
import com.google.gson.annotations.SerializedName

data class CharacterListRequest(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("page")
    val page: Int?
)