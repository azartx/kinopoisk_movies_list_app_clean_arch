package com.solo4.kinoapp.presentation.screens.moviedetails

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.solo4.kinoapp.domain.interactors.GetMovieDetailsInteractor
import javax.inject.Inject

class MovieDetailsViewModelFactory @Inject constructor(
    private val getMovieDetailsInteractor: GetMovieDetailsInteractor
) :
    AbstractSavedStateViewModelFactory() {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return MovieDetailsViewModel(handle, getMovieDetailsInteractor) as T
    }
}
