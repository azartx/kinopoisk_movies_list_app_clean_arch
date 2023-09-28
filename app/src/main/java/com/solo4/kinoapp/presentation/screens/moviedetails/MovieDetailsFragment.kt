package com.solo4.kinoapp.presentation.screens.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.solo4.kinoapp.App
import com.solo4.kinoapp.R
import com.solo4.kinoapp.databinding.FragmentMovieDetailsBinding
import com.solo4.kinoapp.domain.model.Movie
import com.solo4.kinoapp.presentation.utils.popBackStack

class MovieDetailsFragment : Fragment() {

    private val viewModel: MovieDetailsViewModel by viewModels {
        App.appComponent.movieDetailsViewModelFactory
    }

    private var binding: FragmentMovieDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initReceivers()
    }

    private fun initReceivers() {
        viewModel.screenState.observe(viewLifecycleOwner, ::onScreenStateChanged)
    }

    private fun onScreenStateChanged(screenState: MovieDetailsState?) {
        when (screenState) {
            is MovieDetailsState.OnMovieLoaded -> {
                installViewContent(screenState.movie)
            }

            is MovieDetailsState.OnLoadingError -> {
                Toast.makeText(
                    requireContext(),
                    getString(screenState.messageId),
                    Toast.LENGTH_SHORT
                ).show()
                popBackStack()
            }

            else -> Unit
        }
        binding?.progressLoading?.isVisible = screenState is MovieDetailsState.Loading
    }

    private fun installViewContent(movie: Movie) {
        binding?.run {
            Glide.with(root.context)
                .load(movie.posterUrl)
                .into(imageviewPoster)

            textviewMovieTitle.text = movie.name
            textviewMovieDescription.text = movie.description
                ?: getString(R.string.description_is_not_found)
            viewLifecycleOwner.lifecycle.addObserver(videoviewTrailer)
            videoviewTrailer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val youTubeVideoId = movie.videos.trailers
                        .firstOrNull()
                        ?.url
                        ?.substringAfterLast("/", "")
                        ?.takeIf { it.isNotBlank() }
                        ?: return
                    youTubePlayer.loadVideo(youTubeVideoId, 0f)
                    youTubePlayer.pause()
                }
            })
        }
    }

    override fun onDestroyView() {
        binding?.videoviewTrailer?.let { viewLifecycleOwner.lifecycle.removeObserver(it) }
        binding = null
        super.onDestroyView()
    }
}
