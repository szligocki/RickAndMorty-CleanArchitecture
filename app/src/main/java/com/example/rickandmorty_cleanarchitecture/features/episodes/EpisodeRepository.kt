package com.example.rickandmorty_cleanarchitecture.features.episodes

import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}