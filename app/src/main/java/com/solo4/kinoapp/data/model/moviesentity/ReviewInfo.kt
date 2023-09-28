package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class ReviewInfo(
    @SerializedName("count") val count: Int? = null,
    @SerializedName("positiveCount") val positiveCount: Int? = null,
    @SerializedName("percentage") val percentage: String? = null
)
