package com.solo4.kinoapp.domain.repositories

import com.solo4.kinoapp.domain.model.Movie
import io.reactivex.rxjava3.core.Single

interface MovieDetailsRepository {
    fun getMovieById(movieId: Int): Single<Movie>
}
