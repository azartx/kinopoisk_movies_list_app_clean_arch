package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class ImagesInfo(
    @SerializedName("postersCount") val postersCount: Int? = null,
    @SerializedName("backdropsCount") val backdropsCount: Int? = null,
    @SerializedName("framesCount") val framesCount: Int? = null
)