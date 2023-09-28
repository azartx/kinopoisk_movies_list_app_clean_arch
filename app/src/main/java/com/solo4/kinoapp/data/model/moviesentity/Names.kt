package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Names(
    @SerializedName("name") val name: String,
    @SerializedName("language") val language: String? = null,
    @SerializedName("type") val type: String? = null
)
