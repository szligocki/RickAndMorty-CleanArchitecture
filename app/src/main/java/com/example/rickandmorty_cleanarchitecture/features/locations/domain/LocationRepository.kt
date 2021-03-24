package com.example.rickandmorty_cleanarchitecture.features.locations.domain

import com.example.rickandmorty_cleanarchitecture.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocation(): List<Location>
}