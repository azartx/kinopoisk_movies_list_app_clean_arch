package com.solo4.kinoapp.presentation.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.solo4.kinoapp.presentation.screens.moviedetails.MovieDetailsFragment
import com.solo4.kinoapp.presentation.screens.movieslist.MoviesListFragment

sealed interface Route {
    val screenClass: Class<out Fragment>
    val args: Bundle?
    data object MoviesList : Route {
        override val screenClass: Class<out Fragment> = MoviesListFragment::class.java
        override val args: Bundle? = null
    }
    data class MovieDetails(override val args: Bundle) : Route {
        override val screenClass: Class<out Fragment> = MovieDetailsFragment::class.java
    }
}
