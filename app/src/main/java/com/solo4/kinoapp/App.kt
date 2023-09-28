package com.solo4.kinoapp

import android.app.Application
import com.solo4.kinoapp.di.AppComponent
import com.solo4.kinoapp.di.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}
