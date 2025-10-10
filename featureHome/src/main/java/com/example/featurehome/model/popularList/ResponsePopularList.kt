package com.prodigy.feature.girlfriend.model.popularList

import com.google.gson.annotations.SerializedName

data class ResponsePopularList(
    @SerializedName("data")
    val data: List<DataPopularList>,
    @SerializedName("pagination")
    val pagination: Pagination
)