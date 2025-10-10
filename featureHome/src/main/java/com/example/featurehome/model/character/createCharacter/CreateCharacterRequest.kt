package com.prodigy.feature.girlfriend.model.character.createCharacter

import kotlinx.serialization.SerialName

data class CreateCharacterRequest(
    @SerialName("_id")
    val _id: String,
    @SerialName("status")
    val status: Int,
    @SerialName("cate_id")
    val cate_id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("introduction")
    val introduction: String,
    @SerialName("personality")
    val personality: String,
    @SerialName("language_characteristics")
    val language_characteristics: String,
    @SerialName("character_relationship")
    val character_relationship: String,
    @SerialName("preview")
    val preview: String,
    @SerialName("age")
    val age: Int,
    @SerialName("gender")
    val gender: Int,
    @SerialName("persona_tags")
    val persona_tags: List<PersonaTag>
)

data class PersonaTag(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)
