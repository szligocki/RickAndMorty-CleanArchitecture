package com.example.rickandmorty_cleanarchitecture.features.episodes.domain

import com.example.rickandmorty_cleanarchitecture.core.base.UseCase
import com.example.rickandmorty_cleanarchitecture.features.episodes.EpisodeRepository
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}