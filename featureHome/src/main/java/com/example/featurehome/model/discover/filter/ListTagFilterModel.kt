package com.prodigy.feature.girlfriend.model.discover.filter

import com.google.gson.annotations.SerializedName
import com.prodigy.feature.girlfriend.model.discover.filter.Pagination

data class ListTagFilterModel(
    @SerializedName("data")
    val dataTag: List<DataTag>,
    @SerializedName("pagination")
    val pagination: Pagination
)