package com.smerkis.news

import android.app.Application
import com.smerkis.news.di.networkModule
import com.smerkis.news.di.repositoryModule
import com.smerkis.news.di.roomModule
import com.smerkis.news.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            printLogger() // Koin Logger
            androidContext(this@MyApp)
            modules(listOf(roomModule, networkModule, viewModelModule, repositoryModule))
        }
    }

    companion object {
        lateinit var instance: MyApp
            private set
    }
}