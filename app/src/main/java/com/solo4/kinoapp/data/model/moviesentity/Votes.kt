package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Votes(
    @SerializedName("kp") val kp: String? = null,
    @SerializedName("imdb") val imdb: String? = null,
    @SerializedName("tmdb") val tmdb: Int? = null,
    @SerializedName("filmCritics") val filmCritics: Int? = null,
    @SerializedName("russianFilmCritics") val russianFilmCritics: Int? = null,
    @SerializedName("await") val await: Int? = null

)
