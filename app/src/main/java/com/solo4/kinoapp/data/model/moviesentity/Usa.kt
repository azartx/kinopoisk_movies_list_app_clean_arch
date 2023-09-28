package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Usa(
    @SerializedName("value") val value: Int? = null,
    @SerializedName("currency") val currency: String? = null
)
