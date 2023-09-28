package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Backdrop(
    @SerializedName("url") val url: String? = null,
    @SerializedName("previewUrl") val previewUrl: String? = null
)
