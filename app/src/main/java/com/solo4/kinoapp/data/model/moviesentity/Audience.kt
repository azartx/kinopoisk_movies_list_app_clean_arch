package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Audience(
    @SerializedName("count") val count: Int? = null,
    @SerializedName("country") val country: String? = null
)
