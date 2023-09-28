package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class ExternalId(
    @SerializedName("kpHD") val kpHD: String? = null,
    @SerializedName("imdb") val imdb: String? = null,
    @SerializedName("tmdb") val tmdb: Int? = null
)
