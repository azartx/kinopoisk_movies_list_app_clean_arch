package com.solo4.kinoapp.domain.interactors.impl

import androidx.paging.PagingData
import com.solo4.kinoapp.domain.interactors.GetMoviesInteractor
import com.solo4.kinoapp.domain.model.Movie
import com.solo4.kinoapp.domain.repositories.MoviesRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetMoviesInteractorImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetMoviesInteractor {
    override fun execute(pageSize: Int): Observable<PagingData<Movie>> {
        return moviesRepository.getMovies(pageSize)
    }
}
