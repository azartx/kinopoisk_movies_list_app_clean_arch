package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("kp") val kp: Double? = null,
    @SerializedName("imdb") val imdb: Double? = null,
    @SerializedName("tmdb") val tmdb: Double? = null,
    @SerializedName("filmCritics") val filmCritics: Double? = null,
    @SerializedName("russianFilmCritics") val russianFilmCritics: Double? = null,
    @SerializedName("await") val await: Double? = null
)
