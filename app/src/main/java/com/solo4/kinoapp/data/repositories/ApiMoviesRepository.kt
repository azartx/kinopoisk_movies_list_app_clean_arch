package com.solo4.kinoapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import androidx.paging.rxjava3.observable
import com.solo4.kinoapp.data.datasource.MoviesApi
import com.solo4.kinoapp.data.datasource.MoviesPagingSource
import com.solo4.kinoapp.data.mappers.MoviesMapper
import com.solo4.kinoapp.domain.model.Movie
import com.solo4.kinoapp.domain.repositories.MoviesRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ApiMoviesRepository @Inject constructor(
    private val api: MoviesApi,
    private val moviesMapper: MoviesMapper
) : MoviesRepository {
    override fun getMovies(limit: Int): Observable<PagingData<Movie>> {
        return Pager(PagingConfig(
            pageSize = limit
        )) {
            MoviesPagingSource(api)
        }.observable
            .map { it.map { docs -> moviesMapper.mapToDomain(docs) } }
    }
}
