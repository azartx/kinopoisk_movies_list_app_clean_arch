package com.solo4.kinoapp.di

import com.solo4.kinoapp.presentation.MainActivity
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = [PresentationModule::class])
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}
