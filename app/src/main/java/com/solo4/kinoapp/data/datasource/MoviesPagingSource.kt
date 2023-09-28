package com.solo4.kinoapp.data.datasource

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.solo4.kinoapp.data.model.moviesentity.Docs
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class MoviesPagingSource(private val moviesApi: MoviesApi) : RxPagingSource<Int, Docs>() {
    override fun getRefreshKey(state: PagingState<Int, Docs>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Docs>> {
        val nextPageNumber = params.key ?: 1
        return moviesApi.getMovies(nextPageNumber, 10)
            .subscribeOn(Schedulers.io())
            .map { LoadResult.Page(it.docs, null, nextPageNumber + 1) as LoadResult<Int, Docs> }
            .onErrorReturn { LoadResult.Error(it) }
    }
}