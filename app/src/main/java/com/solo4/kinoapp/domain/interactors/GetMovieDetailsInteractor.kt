package com.solo4.kinoapp.domain.interactors

import com.solo4.kinoapp.domain.model.Movie
import io.reactivex.rxjava3.core.Single

interface GetMovieDetailsInteractor {
    fun execute(movieId: Int): Single<Movie>
}
