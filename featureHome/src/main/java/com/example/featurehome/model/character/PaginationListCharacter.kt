package com.prodigy.feature.girlfriend.model.character

import com.google.gson.annotations.SerializedName

data class PaginationListCharacter(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("totalPages")
    val totalPages: Int?
)