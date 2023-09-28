package com.solo4.kinoapp.presentation.screens.movieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.solo4.kinoapp.domain.interactors.impl.GetMoviesInteractorImpl
import javax.inject.Inject

class MoviesListViewModelFactory @Inject constructor(
    private val getMoviesInteractor: GetMoviesInteractorImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesListViewModel(getMoviesInteractor) as T
    }
}
