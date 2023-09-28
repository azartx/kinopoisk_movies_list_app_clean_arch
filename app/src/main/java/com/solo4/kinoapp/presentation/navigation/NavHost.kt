package com.solo4.kinoapp.presentation.navigation

import androidx.fragment.app.FragmentManager
import com.solo4.kinoapp.presentation.MainActivity

/**
 * Nav Host is using for connecting our navigation to specific activity Fragment Manager
 */
interface NavHost {
    var fragmentManager: FragmentManager?

    /**
     * Provide ability to using activity fragment manager
     */
    fun attachToActivity(activity: MainActivity)

    /**
     * Frees up all NavHost resources
     */
    fun detachFromActivity()
}
