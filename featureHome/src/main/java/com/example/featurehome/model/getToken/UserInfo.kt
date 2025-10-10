package com.prodigy.feature.girlfriend.model.getToken

import java.io.Serializable

data class UserInfo(
    val balance: Int?,
    val createdAt: String?,
    val email: String?,
    val id: Int?,
    val name: String?,
    val picture: String?,
    val provider: String?,
    val status: String?
): Serializable