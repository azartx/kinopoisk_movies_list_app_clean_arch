package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Facts(
    @SerializedName("value") val value: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("spoiler") val spoiler: Boolean? = null
)
