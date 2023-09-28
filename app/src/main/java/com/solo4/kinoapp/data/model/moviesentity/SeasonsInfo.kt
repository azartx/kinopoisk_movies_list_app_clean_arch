package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class SeasonsInfo(
    @SerializedName("number") val number: Int? = null,
    @SerializedName("episodesCount") val episodesCount: Int? = null
)
