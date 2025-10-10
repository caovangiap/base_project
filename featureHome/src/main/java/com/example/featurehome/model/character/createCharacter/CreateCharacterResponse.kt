package com.prodigy.feature.girlfriend.model.character.createCharacter

import kotlinx.serialization.SerialName

data class CreateCharacterResponse(
    @SerialName("id")
    val id: Int?,
    @SerialName("uid")
    val uid: String?,
    @SerialName("cate_id")
    val cate_id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("introduction")
    val introduction: String?,
    @SerialName("personality")
    val personality: String?,
    @SerialName("language_characteristics")
    val language_characteristics: String?,
    @SerialName("character_relationship")
    val character_relationship: String?,
    @SerialName("preview")
    val preview: String?,
    @SerialName("age")
    val age: Int?,
    @SerialName("gender")
    val gender: Int?,
    @SerialName("image_link")
    val image_link: String?,
    @SerialName("talk_style")
    val talk_style: String?,
    @SerialName("user_id")
    val user_id: Int?,
    @SerialName("status")
    val status: Int?,
    @SerialName("character_type")
    val character_type: Int?,
    @SerialName("persona_tags")
    val persona_tags: List<PersonaTagResponse>?
)

data class PersonaTagResponse(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?
)
