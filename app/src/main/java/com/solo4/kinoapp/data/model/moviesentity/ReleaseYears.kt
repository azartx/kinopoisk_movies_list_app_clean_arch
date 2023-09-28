package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class ReleaseYears(
    @SerializedName("start") val start: Int? = null,
    @SerializedName("end") val end: Int? = null
)
