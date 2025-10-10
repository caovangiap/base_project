package com.prodigy.feature.girlfriend.model.character

import com.google.gson.annotations.SerializedName

data class ListCharacterResponse(
    @SerializedName("data")
    val data: MutableList<DataListCharacter?>?,
    @SerializedName("pagination")
    val pagination: PaginationListCharacter?
)