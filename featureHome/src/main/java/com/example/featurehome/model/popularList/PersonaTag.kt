package com.prodigy.feature.girlfriend.model.popularList



import com.google.gson.annotations.SerializedName

data class PersonaTag(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)