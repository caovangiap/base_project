package com.example.core.core.data

data class AuthRequest(
    val identifier: String? = null,
    val password: String? = null,
    val captcha: String? = null
)
