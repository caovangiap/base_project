package com.prodigy.feature.girlfriend.model.popularList

import com.google.gson.annotations.SerializedName

data class RequestPopularList(

    @SerializedName("page")
    val page : Int,
    @SerializedName("limit")
    val limit : Int

)
