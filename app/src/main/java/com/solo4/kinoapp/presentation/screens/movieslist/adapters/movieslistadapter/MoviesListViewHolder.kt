package com.solo4.kinoapp.presentation.screens.movieslist.adapters.movieslistadapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solo4.kinoapp.R
import com.solo4.kinoapp.databinding.ItemMovieBinding
import com.solo4.kinoapp.domain.model.Movie

class MoviesListViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Movie) {
        Glide.with(binding.root)
            .load(item.posterUrl)
            .into(binding.imageviewMoviePoster)

        binding.textviewTitle.text = item.name
            ?: itemView.context.getString(R.string.unknown_movie_name)
        binding.textviewDescription.text = item.description
            ?: itemView.context.getString(R.string.empty_movie_description)
    }
}
