package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Watchability(
    @SerializedName("items") val items: ArrayList<Items> = arrayListOf()
)
