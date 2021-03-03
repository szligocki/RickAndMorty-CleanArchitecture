package com.example.rickandmorty_cleanarchitecture.features.episodes.domain

import com.example.rickandmorty_cleanarchitecture.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}