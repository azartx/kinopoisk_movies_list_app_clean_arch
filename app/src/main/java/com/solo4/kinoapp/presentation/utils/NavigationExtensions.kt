package com.solo4.kinoapp.presentation.utils

import android.util.Log
import androidx.fragment.app.Fragment
import com.solo4.kinoapp.presentation.MainActivity
import com.solo4.kinoapp.presentation.navigation.Route

private const val NAVIGATION_TAG = "Navigation"

fun Fragment.navigate(route: Route) {
    (requireActivity() as? MainActivity)?.navController?.navigate(route)
        ?: Log.e(
            NAVIGATION_TAG,
            "Error while navigating to route \"$route\". Can't access Main Activity. "
                .plus("Fragment activity is ${requireActivity()::class.java.name}")
        )
}

fun Fragment.popBackStack() {
    (requireActivity() as? MainActivity)?.navController?.popBackStack(this)
        ?: Log.e(
            NAVIGATION_TAG,
            "Error while trying popBackStack(). Can't access Main Activity. "
                .plus("Fragment activity is ${requireActivity()::class.java.name}")
        )
}
