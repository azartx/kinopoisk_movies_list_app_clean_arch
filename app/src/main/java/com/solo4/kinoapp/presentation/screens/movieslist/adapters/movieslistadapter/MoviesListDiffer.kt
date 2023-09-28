package com.solo4.kinoapp.presentation.screens.movieslist.adapters.movieslistadapter

import androidx.recyclerview.widget.DiffUtil
import com.solo4.kinoapp.domain.model.Movie

class MoviesListDiffer : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }
}
