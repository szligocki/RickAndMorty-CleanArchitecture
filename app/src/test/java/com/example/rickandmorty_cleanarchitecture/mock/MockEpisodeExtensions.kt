package com.example.rickandmorty_cleanarchitecture.mock

import com.example.rickandmorty_cleanarchitecture.core.api.model.episode.EpisodesResponse
import com.example.rickandmorty_cleanarchitecture.core.api.model.episode.ResponseInfo
import com.example.rickandmorty_cleanarchitecture.core.api.model.episode.EpisodeRemote
import com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.rickandmorty_cleanarchitecture.features.episodes.data.local.model.EpisodeCached
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.model.Episode
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "Next page",
    prev = "Prev page"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun Episode.Companion.mock() = Episode (
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable (
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)