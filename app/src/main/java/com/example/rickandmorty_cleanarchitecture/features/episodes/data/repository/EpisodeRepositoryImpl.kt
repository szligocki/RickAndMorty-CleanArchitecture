package com.example.rickandmorty_cleanarchitecture.features.episodes.data.repository

import com.example.rickandmorty_cleanarchitecture.core.api.RickAndMortyApi
import com.example.rickandmorty_cleanarchitecture.core.network.NetworkStateProvider
import com.example.rickandmorty_cleanarchitecture.features.episodes.data.local.EpisodeDao
import com.example.rickandmorty_cleanarchitecture.features.episodes.data.local.model.EpisodeCached
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.EpisodeRepository
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getEpisodesFromRemote()
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisodes()
            .results
            .map { it.toEpisode() }

    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes()
            .map { it.toEpisode() }
    }
}