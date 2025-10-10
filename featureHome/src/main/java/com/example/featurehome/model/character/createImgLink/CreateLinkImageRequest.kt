package com.prodigy.feature.girlfriend.model.character.createImgLink

import kotlinx.serialization.SerialName


data class CreateLinkImageRequest(
    @SerialName("cate_name")
    val cate_name: String,
    @SerialName("description")
    val description: String,
    @SerialName("reference_image")
    val referenceImage: String?,
    @SerialName("style")
    val style: String,
    @SerialName("tier")
    val tier: String
)