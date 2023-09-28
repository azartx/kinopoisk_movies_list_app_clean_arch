package com.solo4.kinoapp.presentation.navigation.impl

import androidx.fragment.app.FragmentManager
import com.solo4.kinoapp.presentation.MainActivity
import com.solo4.kinoapp.presentation.navigation.NavHost
import javax.inject.Inject

class MainActivityNavHost @Inject constructor() : NavHost,
    FragmentManager.OnBackStackChangedListener {

    override var fragmentManager: FragmentManager? = null
    private var mainActivity: MainActivity? = null

    override fun attachToActivity(activity: MainActivity) {
        fragmentManager = activity.supportFragmentManager
        mainActivity = activity
        activity.supportFragmentManager.addOnBackStackChangedListener(this)
    }

    override fun detachFromActivity() {
        fragmentManager?.removeOnBackStackChangedListener(this)
        fragmentManager = null
        mainActivity = null
    }

    // close an activity if all fragments are closed
    override fun onBackStackChanged() {
        if (fragmentManager?.backStackEntryCount == 0) {
            mainActivity?.onBackPressed()
        }
    }
}
