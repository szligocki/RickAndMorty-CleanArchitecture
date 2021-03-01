package com.example.rickandmorty_cleanarchitecture.features.locations.domain

import com.example.rickandmorty_cleanarchitecture.core.base.UseCase
import com.example.rickandmorty_cleanarchitecture.features.locations.LocationRepository
import com.example.rickandmorty_cleanarchitecture.features.locations.domain.model.Location

class GetLocationUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit): List<Location> = locationRepository.getLocation()
}