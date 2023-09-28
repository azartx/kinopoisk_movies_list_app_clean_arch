package com.solo4.kinoapp.presentation.screens.moviedetails

import androidx.annotation.StringRes
import com.solo4.kinoapp.domain.model.Movie

sealed class MovieDetailsState {
    data object Loading : MovieDetailsState()
    data class OnMovieLoaded(val movie: Movie) : MovieDetailsState()
    data class OnLoadingError(@StringRes val messageId: Int) : MovieDetailsState()
}
