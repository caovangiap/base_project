package com.prodigy.feature.girlfriend.model.discover.search

import com.google.gson.annotations.SerializedName

data class DataSearch(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_link")
    val imageLink: String,
    @SerializedName("introduction")
    val introduction: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("persona_tags")
    var personaTags: List<PersonaTagPaginationSearch> ? =null
)