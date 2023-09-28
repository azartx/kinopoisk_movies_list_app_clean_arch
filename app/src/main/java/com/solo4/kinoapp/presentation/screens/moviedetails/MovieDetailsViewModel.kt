package com.solo4.kinoapp.presentation.screens.moviedetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.solo4.kinoapp.R
import com.solo4.kinoapp.common.utils.PICKED_MOVIE_ID_KEY
import com.solo4.kinoapp.domain.interactors.GetMovieDetailsInteractor
import com.solo4.kinoapp.common.utils.plusAssign
import io.reactivex.rxjava3.disposables.CompositeDisposable
import com.solo4.kinoapp.common.utils.VM_TAG

class MovieDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    getMovieDetailsInteractor: GetMovieDetailsInteractor
) : ViewModel() {

    private val _screenState = MutableLiveData<MovieDetailsState>(MovieDetailsState.Loading)
    val screenState: LiveData<MovieDetailsState> = _screenState

    private val disposableBag: CompositeDisposable = CompositeDisposable()

    init {
        initScreenState(savedStateHandle, getMovieDetailsInteractor)
    }

    private fun initScreenState(
        savedStateHandle: SavedStateHandle,
        getMovieDetailsInteractor: GetMovieDetailsInteractor
    ) {
        val currentMovieId = savedStateHandle.get<Int>(PICKED_MOVIE_ID_KEY)

        if (currentMovieId == null) {
            _screenState.postValue(
                MovieDetailsState.OnLoadingError(R.string.unexpected_error_try_again)
            )
            return
        }

        disposableBag += getMovieDetailsInteractor.execute(currentMovieId)
            .subscribe { movie, error ->
                if (movie != null) {
                    _screenState.postValue(MovieDetailsState.OnMovieLoaded(movie))
                } else {
                    Log.e(VM_TAG, "Error while loading Movie details from server", error)
                    _screenState.postValue(
                        MovieDetailsState.OnLoadingError(R.string.error_loading_from_server_try_again)
                    )
                }
            }
    }

    override fun onCleared() {
        if (!disposableBag.isDisposed) disposableBag.dispose()
        super.onCleared()
    }
}
