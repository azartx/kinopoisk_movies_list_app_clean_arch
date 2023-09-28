package com.solo4.kinoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.solo4.kinoapp.App
import com.solo4.kinoapp.R
import com.solo4.kinoapp.di.MainActivityComponent
import com.solo4.kinoapp.presentation.navigation.NavController
import com.solo4.kinoapp.presentation.navigation.NavHost
import com.solo4.kinoapp.presentation.screens.movieslist.MoviesListFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var mainActivityComponent: MainActivityComponent? = null

    @Inject
    lateinit var navController: NavController
    @Inject
    lateinit var navHost: NavHost

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = App.appComponent.mainActivityComponentFactory().create().apply {
            inject(this@MainActivity) // ?????????????????
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        navHost.attachToActivity(this)
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_root,
                MoviesListFragment::class.java,
                null
            )
            .addToBackStack(this::class.java.name)
            .commit()
    }

    override fun onDestroy() {
        mainActivityComponent = null
        super.onDestroy()
    }
}
