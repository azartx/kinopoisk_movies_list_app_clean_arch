package com.solo4.kinoapp.data

import androidx.paging.PagingData
import com.solo4.kinoapp.domain.model.Movie
import com.solo4.kinoapp.domain.repositories.MoviesRepository
import io.reactivex.rxjava3.core.Observable

class FakeMoviesRepository : MoviesRepository {
    override fun getMovies(limit: Int): Observable<PagingData<Movie>> {
        return Observable.just(PagingData.empty())
    }
}
