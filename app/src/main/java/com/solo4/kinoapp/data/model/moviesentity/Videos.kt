package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Videos(
    @SerializedName("trailers") val trailers: ArrayList<Trailers> = arrayListOf(),
    @SerializedName("teasers") val teasers: ArrayList<Teasers> = arrayListOf()
)
