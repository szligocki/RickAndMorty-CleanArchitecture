package com.example.rickandmorty_cleanarchitecture.core.api

import com.example.rickandmorty_cleanarchitecture.core.api.model.character.CharactersResponse
import com.example.rickandmorty_cleanarchitecture.core.api.model.episode.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episodes")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("characters")
    suspend fun getCharacters(): CharactersResponse
}