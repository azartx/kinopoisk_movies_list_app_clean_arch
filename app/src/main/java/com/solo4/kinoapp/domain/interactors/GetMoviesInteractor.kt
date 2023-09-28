package com.solo4.kinoapp.domain.interactors

import androidx.paging.PagingData
import com.solo4.kinoapp.domain.model.Movie
import io.reactivex.rxjava3.core.Observable

interface GetMoviesInteractor {
    fun execute(pageSize: Int): Observable<PagingData<Movie>>
}
