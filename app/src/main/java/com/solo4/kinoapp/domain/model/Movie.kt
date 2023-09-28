package com.solo4.kinoapp.domain.model

data class Movie(
    val id: Int,
    val name: String?,
    val description: String?,
    val posterUrl: String?,
    val videos: VideoTypes
)
