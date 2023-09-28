package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("name") val name: String? = null,
    @SerializedName("logo") val logo: Logo? = Logo(),
    @SerializedName("url") val url: String? = null
)
