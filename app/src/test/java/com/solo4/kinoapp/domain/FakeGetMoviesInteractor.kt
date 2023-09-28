package com.solo4.kinoapp.domain

import androidx.paging.PagingData
import com.solo4.kinoapp.domain.interactors.GetMoviesInteractor
import com.solo4.kinoapp.domain.model.Movie
import io.reactivex.rxjava3.core.Observable

class FakeGetMoviesInteractor : GetMoviesInteractor {
    override fun execute(pageSize: Int): Observable<PagingData<Movie>> {
        return Observable.just(PagingData.from(listOf()))
    }
}
