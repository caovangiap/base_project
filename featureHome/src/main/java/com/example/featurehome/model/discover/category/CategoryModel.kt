package com.prodigy.feature.girlfriend.model.discover.category

import com.android.ai.girl.cache.domain.entity.CategoryLocal
import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("cate_id")
    val cateId: Int? = null,
    @SerializedName("cate_name")
    val cateName: String? = null
) {
    fun toCategoryLocal() = CategoryLocal(
        id = cateId ?: -1, name = cateName
    )
}