package com.prodigy.feature.girlfriend.model

import com.google.gson.annotations.SerializedName

data class DataRequestEncryptModel (
    @SerializedName("data")
    val data: String,
)