package com.solo4.kinoapp.presentation.navigation.impl

import android.util.Log
import androidx.fragment.app.Fragment
import com.solo4.kinoapp.R
import com.solo4.kinoapp.presentation.navigation.NavController
import com.solo4.kinoapp.presentation.navigation.NavHost
import com.solo4.kinoapp.presentation.navigation.Route
import javax.inject.Inject

class MainActivityNavController @Inject constructor(
    private val navHost: NavHost
) : NavController {
    override fun navigate(route: Route) {
        navHost.fragmentManager?.beginTransaction()
            ?.replace(
                R.id.fragment_container_root,
                route.screenClass,
                route.args
            )
            ?.addToBackStack(route.screenClass.name)
            ?.commit()
            ?: run {
                Log.e(
                    this::class.java.name,
                    "Unable to navigate to the $route. Fragment manager is null."
                )
            }
    }

    override fun popBackStack(fragment: Fragment) {
        navHost.fragmentManager?.apply {
            this.popBackStack()
            beginTransaction()
                .remove(fragment)
                .commit()
        }
            ?: run {
                Log.e(
                    this::class.java.name,
                    "Unable to popBackStack. Fragment manager is null."
                )
            }
    }
}
