package com.prodigy.feature.girlfriend.model.discover.search

import com.android.ai.girl.cache.domain.entity.CharacterLocal
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
){
    fun toCharacterLocal() = CharacterLocal(
        id = id,
        categoryId = null,
        name = name,
        introduction = introduction,
        personality = null,
        languageCharacteristics = null,
        characterRelationship = null,
        preview = null,
        age = null,
        gender = null,
        imageLink = imageLink,
    )

    fun toPersonaTagLocalList() = personaTags?.map { it.toPersonaTagLocal() } ?: listOf()
}