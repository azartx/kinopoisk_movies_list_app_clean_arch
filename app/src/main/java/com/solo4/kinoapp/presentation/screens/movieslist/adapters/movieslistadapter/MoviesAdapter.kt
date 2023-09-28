package com.solo4.kinoapp.presentation.screens.movieslist.adapters.movieslistadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.solo4.kinoapp.common.utils.LambdaWithParameter
import com.solo4.kinoapp.databinding.ItemMovieBinding
import com.solo4.kinoapp.domain.model.Movie

class MoviesAdapter(private val onItemClick: LambdaWithParameter<Movie>) :
    PagingDataAdapter<Movie, MoviesListViewHolder>(MoviesListDiffer()), OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        return MoviesListViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                .apply { root.setOnClickListener(this@MoviesAdapter) }
        )
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        val item = getItem(position) ?: let {
            Log.e(this::class.java.name, "Item on position $position is not found!")
            return
        }
        holder.itemView.tag = item
        holder.bind(item)
    }

    override fun onClick(view: View) {
        val item = (view.tag as? Movie) ?: let {
            Log.e(this::class.java.name, "View tag has no any items.")
            return
        }
        onItemClick.invoke(item)
    }
}
