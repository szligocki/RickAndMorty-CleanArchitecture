package com.example.rickandmorty_cleanarchitecture.features.locations.di

import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.LocationRepository
import com.example.rickandmorty_cleanarchitecture.features.locations.data.repository.LocationRepositoryImpl
import com.example.rickandmorty_cleanarchitecture.features.locations.domain.GetLocationUseCase
import com.example.rickandmorty_cleanarchitecture.features.locations.presentation.model.LocationFragment
import com.example.rickandmorty_cleanarchitecture.features.locations.presentation.model.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get(), get()) }
    factory { LocationFragment() }
}