package com.example.rickandmorty_cleanarchitecture.features.episodes.navigation

import com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}