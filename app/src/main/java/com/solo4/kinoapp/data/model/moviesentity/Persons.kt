package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Persons(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("photo") val photo: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("enName") val enName: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("profession") val profession: String? = null,
    @SerializedName("enProfession") val enProfession: String? = null
)
