package com.prodigy.feature.girlfriend.model.discover.search

import com.google.gson.annotations.SerializedName

data class ResponseSearchModel(
    @SerializedName("data")
    val data: List<DataSearch>,
    @SerializedName("pagination")
    val pagination: PaginationSearch
)