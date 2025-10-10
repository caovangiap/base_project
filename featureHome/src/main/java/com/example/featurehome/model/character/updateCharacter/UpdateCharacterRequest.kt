package com.prodigy.feature.girlfriend.model.character.updateCharacter

import com.google.gson.annotations.SerializedName
import com.prodigy.feature.girlfriend.model.character.createCharacter.PersonaTag

data class UpdateCharacterRequest(
    @SerializedName("character_id")
    val character_id: Int,
    @SerializedName("_id")
    val _id: String? = null,
    @SerializedName("status")
    val status: Int? = null,
    @SerializedName("cate_id")
    val cate_id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("introduction")
    val introduction: String? = null,
    @SerializedName("personality")
    val personality: String? = null,
    @SerializedName("language_characteristics")
    val language_characteristics: String? = null,
    @SerializedName("character_relationship")
    val character_relationship: String? = null,
    @SerializedName("preview")
    val preview: String? = null,
    @SerializedName("age")
    val age: Int? = null,
    @SerializedName("gender")
    val gender: Int? = null,
    @SerializedName("persona_tags")
    val persona_tags: List<PersonaTag>? = null
)
