package com.example.rickandmorty_cleanarchitecture.features.characters.di

import com.example.rickandmorty_cleanarchitecture.features.characters.data.repository.CharactersRepositoryImpl

import com.example.rickandmorty_cleanarchitecture.features.characters.domain.GetCharactersUseCase
import com.example.rickandmorty_cleanarchitecture.features.characters.all.presentation.CharactersFragment
import com.example.rickandmorty_cleanarchitecture.features.characters.all.presentation.CharactersViewModel
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.CharacterRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharactersRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharactersViewModel(get(), get()) }
    factory { CharactersFragment() }
}