package com.example.rickandmorty_cleanarchitecture.features.episodes.di

import com.example.rickandmorty_cleanarchitecture.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.EpisodeRepository
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.GetEpisodesUseCase
import com.example.rickandmorty_cleanarchitecture.features.episodes.presentation.EpisodeFragment
import com.example.rickandmorty_cleanarchitecture.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}