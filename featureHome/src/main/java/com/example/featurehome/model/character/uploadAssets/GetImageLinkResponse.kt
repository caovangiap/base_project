package com.prodigy.feature.girlfriend.model.character.uploadAssets

import kotlinx.serialization.SerialName

data class GetImageLinkResponse(
    @SerialName("_id")
    val _id: String?,
    @SerialName("link_upload")
    val link_upload: List<String?>?
)
