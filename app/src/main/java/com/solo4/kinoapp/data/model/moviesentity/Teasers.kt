package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Teasers(
    @SerializedName("url") val url: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("site") val site: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("size") val size: Int
)
