package com.example.rickandmorty_cleanarchitecture.core.api

import com.example.rickandmorty_cleanarchitecture.core.api.model.character.CharactersResponse
import com.example.rickandmorty_cleanarchitecture.core.api.model.episode.EpisodesResponse
import com.example.rickandmorty_cleanarchitecture.core.api.model.location.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse
}