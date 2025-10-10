package com.prodigy.feature.girlfriend.model.discover.search

import com.google.gson.annotations.SerializedName

data class SearchBodyRequest(
    @SerializedName("cateId")
    var cateId: Int? = null,
    @SerializedName("gender")
    var gender: Int? = null,
    @SerializedName("limit")
    var limit: Int,
    @SerializedName("maxAge")
    var maxAge: Int? = null,
    @SerializedName("minAge")
    var minAge: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("page")
    var page: Int,
    @SerializedName("tagIds")
    var tagIds: List<Int>? = null
)