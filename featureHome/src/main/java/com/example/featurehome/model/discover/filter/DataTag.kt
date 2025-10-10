package com.prodigy.feature.girlfriend.model.discover.filter

import com.android.ai.girl.cache.domain.entity.PersonaTagLocal
import com.google.gson.annotations.SerializedName

data class DataTag(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
) {
    fun toPersonaTagLocal() = PersonaTagLocal(
        id = id, name = name
    )
}