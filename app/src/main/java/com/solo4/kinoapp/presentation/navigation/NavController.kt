package com.solo4.kinoapp.presentation.navigation

import androidx.fragment.app.Fragment

interface NavController {
    fun navigate(route: Route)
    fun popBackStack(fragment: Fragment)
}
