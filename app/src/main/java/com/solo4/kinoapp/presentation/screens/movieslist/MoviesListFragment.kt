package com.solo4.kinoapp.presentation.screens.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.solo4.kinoapp.App
import com.solo4.kinoapp.common.utils.PICKED_MOVIE_ID_KEY
import com.solo4.kinoapp.databinding.FragmentMoviesListBinding
import com.solo4.kinoapp.presentation.navigation.Route
import com.solo4.kinoapp.presentation.screens.movieslist.adapters.movieslistadapter.MoviesAdapter
import com.solo4.kinoapp.presentation.utils.navigate

typealias MoviesLoadStateListener = (CombinedLoadStates) -> Unit

class MoviesListFragment : Fragment() {
    private val viewModel: MoviesListViewModel by viewModels {
        App.appComponent.moviesListViewModelFactory
    }
    private var binding: FragmentMoviesListBinding? = null
    private val adapter: MoviesAdapter = MoviesAdapter {
        navigate(Route.MovieDetails(bundleOf(PICKED_MOVIE_ID_KEY to it.id)))
    }

    private var moviesLoadStateListener: MoviesLoadStateListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerMovies?.adapter = adapter
        moviesLoadStateListener = { state ->
            binding?.progressLoading?.isVisible =
                state.refresh is LoadState.Loading || state.append is LoadState.Loading
        }
        moviesLoadStateListener?.let { adapter.addLoadStateListener(it) }

        initReceivers()
    }

    private fun initReceivers() {
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitData(lifecycle, it ?: return@observe)
        }
    }

    override fun onDestroyView() {
        moviesLoadStateListener?.let { adapter.removeLoadStateListener(it) }
        binding = null
        super.onDestroyView()
    }
}
