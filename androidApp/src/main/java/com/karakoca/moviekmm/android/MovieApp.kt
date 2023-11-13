package com.karakoca.moviekmm.android

import android.app.Application
import com.karakoca.moviekmm.android.di.appModule
import com.karakoca.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}