package com.prodigy.feature.girlfriend.model.popularList

import android.os.Parcelable

import com.google.gson.annotations.SerializedName



data class DataPopularList(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_link")
    val imageLink: String,
    @SerializedName("introduction")
    val introduction: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("persona_tags")
    val personaTags: List<PersonaTag>,
    var rotitaonView: Int = 0
)