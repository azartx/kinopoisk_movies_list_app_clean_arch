package com.solo4.kinoapp.di

import com.solo4.kinoapp.presentation.navigation.NavController
import com.solo4.kinoapp.presentation.navigation.NavHost
import com.solo4.kinoapp.presentation.navigation.impl.MainActivityNavController
import com.solo4.kinoapp.presentation.navigation.impl.MainActivityNavHost
import dagger.Binds
import dagger.Module

@Module
interface PresentationModule {
    @MainActivityScope
    @Binds
    fun bindMainActivityNavController(
        mainActivityNavController: MainActivityNavController
    ): NavController

    @MainActivityScope
    @Binds
    fun bindMainActivityNavHost(
        mainActivityNavHost: MainActivityNavHost
    ): NavHost
}
