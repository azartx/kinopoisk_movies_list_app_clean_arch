package com.solo4.kinoapp.data.repositories

import com.solo4.kinoapp.data.datasource.MoviesApi
import com.solo4.kinoapp.data.mappers.MoviesMapper
import com.solo4.kinoapp.domain.model.Movie
import com.solo4.kinoapp.domain.repositories.MovieDetailsRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ApiMovieDetailsRepository @Inject constructor(
    private val api: MoviesApi,
    private val moviesMapper: MoviesMapper
) : MovieDetailsRepository {
    override fun getMovieById(movieId: Int): Single<Movie> {
        return api.getMovieById(movieId)
            .subscribeOn(Schedulers.io())
            .map { moviesMapper.mapToDomain(it) }
    }
}
