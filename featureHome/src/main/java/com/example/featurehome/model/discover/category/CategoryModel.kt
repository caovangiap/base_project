package com.prodigy.feature.girlfriend.model.discover.category


import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("cate_id")
    val cateId: Int? = null,
    @SerializedName("cate_name")
    val cateName: String? = null
)