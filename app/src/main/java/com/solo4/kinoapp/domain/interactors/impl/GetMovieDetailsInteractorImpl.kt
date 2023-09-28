package com.solo4.kinoapp.domain.interactors.impl

import com.solo4.kinoapp.domain.interactors.GetMovieDetailsInteractor
import com.solo4.kinoapp.domain.model.Movie
import com.solo4.kinoapp.domain.repositories.MovieDetailsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetMovieDetailsInteractorImpl @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
) : GetMovieDetailsInteractor {
    override fun execute(movieId: Int): Single<Movie> {
        return movieDetailsRepository.getMovieById(movieId)
    }
}
