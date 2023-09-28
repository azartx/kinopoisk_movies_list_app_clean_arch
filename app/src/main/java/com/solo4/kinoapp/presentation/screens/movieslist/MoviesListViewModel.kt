package com.solo4.kinoapp.presentation.screens.movieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.solo4.kinoapp.common.utils.MOVIES_LIST_PAGE_SIZE
import com.solo4.kinoapp.domain.interactors.GetMoviesInteractor
import com.solo4.kinoapp.domain.model.Movie

class MoviesListViewModel(getMoviesInteractor: GetMoviesInteractor) : ViewModel() {

    private val _movies = MutableLiveData<PagingData<Movie>>()
    val movies: LiveData<PagingData<Movie>> = _movies

    private val moviesObserverDisposable = getMoviesInteractor
        .execute(MOVIES_LIST_PAGE_SIZE)
        .subscribe { _movies.postValue(it) }

    override fun onCleared() {
        if (!moviesObserverDisposable.isDisposed) moviesObserverDisposable.dispose()
        super.onCleared()
    }
}
