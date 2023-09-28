package com.solo4.kinoapp.data

import androidx.paging.PagingData
import com.solo4.kinoapp.domain.model.Movie
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test

class MoviesListRepositoryTest {
    private val fakeMoviesRepository = FakeMoviesRepository()

    private var disposableBag: CompositeDisposable? = null

    @Before
    fun initializeTest() {
        if (disposableBag?.isDisposed == false) disposableBag?.dispose()
        disposableBag = CompositeDisposable()
    }

    @Test
    fun `get movies success`() {
        val disposable = fakeMoviesRepository.getMovies(10)
            .test()
            .assertComplete()
            .assertValue { it is PagingData<Movie> }

        disposableBag?.add(disposable)
    }
}
