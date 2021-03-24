package com.example.rickandmorty_cleanarchitecture.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featuresModule
    .plus(appModule)
    .plus(networkModule)
    .plus(databaseModule)
