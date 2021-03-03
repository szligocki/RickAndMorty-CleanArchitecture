package com.example.rickandmorty_cleanarchitecture.core.api

import com.example.rickandmorty_cleanarchitecture.core.api.model.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episodes")
    suspend fun getEpisodes(): EpisodesResponse
}