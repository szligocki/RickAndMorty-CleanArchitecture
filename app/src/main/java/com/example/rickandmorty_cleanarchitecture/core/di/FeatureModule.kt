package com.example.rickandmorty_cleanarchitecture.core.di

import com.example.rickandmorty_cleanarchitecture.features.characters.di.characterModule
import com.example.rickandmorty_cleanarchitecture.features.episodes.di.episodeModule
import org.koin.core.module.Module

val featuresModule =  listOf<Module>(
    episodeModule,
    characterModule
)
