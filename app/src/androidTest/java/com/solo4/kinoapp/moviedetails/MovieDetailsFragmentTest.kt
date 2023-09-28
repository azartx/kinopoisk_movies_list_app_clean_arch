package com.solo4.kinoapp.moviedetails

import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.solo4.kinoapp.presentation.screens.moviedetails.MovieDetailsFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDetailsFragmentTest {
    @Test
    fun launchFragmentWithoutArguments_ErrorState() {
        /*val scenario = launchFragment { MovieDetailsFragment() }

        scenario.moveToState(Lifecycle.State.RESUMED)

        scenario.onFragment { fragment ->
            fragment.viewModel.screenState.observeForever {

            }
        }*/
    }
}
