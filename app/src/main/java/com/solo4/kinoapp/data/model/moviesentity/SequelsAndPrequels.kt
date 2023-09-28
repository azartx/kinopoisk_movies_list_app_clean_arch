package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class SequelsAndPrequels(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("enName") val enName: String? = null,
    @SerializedName("alternativeName") val alternativeName: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("poster") val poster: Poster? = Poster()
)
