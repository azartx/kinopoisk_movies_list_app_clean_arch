package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Premiere(
    @SerializedName("country") val country: String? = null,
    @SerializedName("world") val world: String? = null,
    @SerializedName("russia") val russia: String? = null,
    @SerializedName("digital") val digital: String? = null,
    @SerializedName("cinema") val cinema: String? = null,
    @SerializedName("bluray") val bluray: String? = null,
    @SerializedName("dvd") val dvd: String? = null
)
