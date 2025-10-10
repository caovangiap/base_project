package com.prodigy.feature.girlfriend.model.discover.search


import com.google.gson.annotations.SerializedName

data class PersonaTagPaginationSearch(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)