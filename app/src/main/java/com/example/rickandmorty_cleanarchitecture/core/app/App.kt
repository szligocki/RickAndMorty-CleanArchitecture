package com.example.rickandmorty_cleanarchitecture.core.app

import android.app.Application
import com.example.rickandmorty_cleanarchitecture.core.di.koinInjector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(koinInjector)
        }
    }
}