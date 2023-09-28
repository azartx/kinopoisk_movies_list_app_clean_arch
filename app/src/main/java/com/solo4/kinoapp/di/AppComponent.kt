package com.solo4.kinoapp.di

import android.app.Application
import com.solo4.kinoapp.presentation.screens.moviedetails.MovieDetailsViewModelFactory
import com.solo4.kinoapp.presentation.screens.movieslist.MoviesListViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataModule::class,
    DomainModule::class,
    Subcomponents::class
])
interface AppComponent {

    val moviesListViewModelFactory: MoviesListViewModelFactory
    val movieDetailsViewModelFactory: MovieDetailsViewModelFactory

    fun mainActivityComponentFactory(): MainActivityComponent.Factory

    @Component.Builder
    interface Builder {
        fun application(@BindsInstance application: Application): Builder
        fun build(): AppComponent
    }
}
