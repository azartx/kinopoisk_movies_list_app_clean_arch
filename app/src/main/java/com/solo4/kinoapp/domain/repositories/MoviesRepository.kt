package com.solo4.kinoapp.domain.repositories

import androidx.paging.PagingData
import com.solo4.kinoapp.domain.model.Movie
import io.reactivex.rxjava3.core.Observable

interface MoviesRepository {
    fun getMovies(limit: Int): Observable<PagingData<Movie>>
}
