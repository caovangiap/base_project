package com.example.core.core.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("accept_eula")
    val acceptEula: Boolean,

    @SerializedName("active")
    val active: Boolean,

    @SerializedName("device_token")
    val deviceToken: String,

    @SerializedName("expired_at")
    val expiredAt: Int,

    @SerializedName("ez_token")
    val ezToken: String,

    @SerializedName("is_admin")
    val isAdmin: Boolean,

    @SerializedName("name")
    val name: String,

    @SerializedName("org_id")
    val orgId: String,

    @SerializedName("org_name")
    val orgName: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("project_id")
    val projectId: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("role_id")
    val roleId: String,

    @SerializedName("role_name")
    val roleName: String,

    @SerializedName("system_role")
    val systemRole: String,

    @SerializedName("token")
    val token: String,

    @SerializedName("user_id")
    val userId: String,

    @SerializedName("user_name")
    val userName: String
)