package com.prodigy.feature.girlfriend.model.character.createImgLink

import kotlinx.serialization.SerialName

data class CreateLinkImageResponse(
    @SerialName("_id")
    val _id: String?,
    @SerialName("firebase_token")
    val firebaseToken: String?,
    @SerialName("message")
    val message: String?,
    @SerialName("os")
    val os: String?,
    @SerialName("result")
    val result: LinkImageResult?,
    @SerialName("status_code")
    val statusCode: Int?,
    @SerialName("user_id")
    val userId: Int?
)