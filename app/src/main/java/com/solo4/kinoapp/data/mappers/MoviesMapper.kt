package com.solo4.kinoapp.data.mappers

import com.solo4.kinoapp.data.model.moviesentity.Docs
import com.solo4.kinoapp.domain.model.Movie
import com.solo4.kinoapp.domain.model.Video
import com.solo4.kinoapp.domain.model.VideoTypes
import javax.inject.Inject

class MoviesMapper @Inject constructor() {
    fun mapToDomain(movieEntity: Docs): Movie {
        return Movie(
            id = movieEntity.id,
            name = movieEntity.name,
            description = movieEntity.description,
            posterUrl = movieEntity.poster?.url,
            videos = VideoTypes(
                trailers = movieEntity.videos?.trailers
                    ?.filter { it.url != null }
                    ?.map {
                        Video(
                            url = it.url!!,
                            name = it.name,
                            site = it.site,
                            size = it.size
                        )
                    } ?: listOf(),
                teasers = movieEntity.videos?.teasers
                    ?.filter { it.url != null }
                    ?.map {
                        Video(
                            url = it.url!!,
                            name = it.name,
                            site = it.site,
                            size = it.size
                        )
                    } ?: listOf()
            )
        )
    }
}
