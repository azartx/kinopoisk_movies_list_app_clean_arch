package com.solo4.kinoapp.di

import com.solo4.kinoapp.data.repositories.ApiMovieDetailsRepository
import com.solo4.kinoapp.data.repositories.ApiMoviesRepository
import com.solo4.kinoapp.domain.interactors.GetMovieDetailsInteractor
import com.solo4.kinoapp.domain.interactors.GetMoviesInteractor
import com.solo4.kinoapp.domain.interactors.impl.GetMovieDetailsInteractorImpl
import com.solo4.kinoapp.domain.interactors.impl.GetMoviesInteractorImpl
import com.solo4.kinoapp.domain.repositories.MovieDetailsRepository
import com.solo4.kinoapp.domain.repositories.MoviesRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DomainModule.DomainBinds::class])
object DomainModule {
    @Module
    interface DomainBinds {
        @Binds
        fun bindApiMoviesRepositoryToMoviesRepository(
            apiMoviesRepository: ApiMoviesRepository
        ): MoviesRepository

        @Binds
        fun bindGetMoviesInteractorImplToGetMoviesInteractor(
            getMoviesInteractorImpl: GetMoviesInteractorImpl
        ): GetMoviesInteractor

        @Binds
        fun bindGetMovieDetailsInteractorImplToGetMovieDetailsInteractor(
            getMovieDetailsInteractorImpl: GetMovieDetailsInteractorImpl
        ): GetMovieDetailsInteractor

        @Binds
        fun bindApiMovieDetailsRepositoryToMovieDetailsRepository(
            apiMovieDetailsRepository: ApiMovieDetailsRepository
        ): MovieDetailsRepository
    }
}
