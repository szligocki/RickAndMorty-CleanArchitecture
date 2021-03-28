package com.example.rickandmorty_cleanarchitecture.features.locations.navigator

import com.example.rickandmorty_cleanarchitecture.features.locations.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}