package com.prodigy.feature.girlfriend.model.character.updateCharacter

import com.google.gson.annotations.SerializedName
import com.prodigy.feature.girlfriend.model.character.createCharacter.PersonaTag

data class UpdateCharacterResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("uid")
    val uid: String?,
    @SerializedName("cate_id")
    val cate_id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("introduction")
    val introduction: String?,
    @SerializedName("personality")
    val personality: String?,
    @SerializedName("language_characteristics")
    val language_characteristics: String?,
    @SerializedName("character_relationship")
    val character_relationship: String?,
    @SerializedName("preview")
    val preview: String?,
    @SerializedName("age")
    val age: Int?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("image_link")
    val image_link: String?,
    @SerializedName("talk_style")
    val talk_style: String?,
    @SerializedName("user_id")
    val user_id: Int?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("character_type")
    val character_type: Int?,
    @SerializedName("persona_tags")
    val persona_tags: List<PersonaTag>?,
    @SerializedName("message")
    val message: String?
)
