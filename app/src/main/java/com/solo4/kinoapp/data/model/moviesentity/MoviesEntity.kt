package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class MoviesEntity(
    @SerializedName("docs") val docs: ArrayList<Docs> = arrayListOf(),
    @SerializedName("total") val total: Int? = null,
    @SerializedName("limit") val limit: Int? = null,
    @SerializedName("page") val page: Int? = null,
    @SerializedName("pages") val pages: Int? = null
)
