package com.prodigy.feature.girlfriend.model.character.uploadAssets

import kotlinx.serialization.SerialName

data class GetImageLinkRequest(
    @SerialName("original_name")
    val original_name: List<String>
)
