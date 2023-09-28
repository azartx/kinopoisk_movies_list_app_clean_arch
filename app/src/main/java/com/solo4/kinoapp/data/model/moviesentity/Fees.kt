package com.solo4.kinoapp.data.model.moviesentity

import com.google.gson.annotations.SerializedName

data class Fees(
    @SerializedName("world") val world: World? = World(),
    @SerializedName("russia") val russia: Russia? = Russia(),
    @SerializedName("usa") val usa: Usa? = Usa()
)
