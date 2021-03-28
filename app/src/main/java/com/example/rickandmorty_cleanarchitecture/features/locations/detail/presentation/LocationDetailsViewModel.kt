package com.example.rickandmorty_cleanarchitecture.features.locations.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_cleanarchitecture.core.base.BaseViewModel
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorMapper
import com.example.rickandmorty_cleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import com.example.rickandmorty_cleanarchitecture.features.locations.domain.GetLocationUseCase
import com.example.rickandmorty_cleanarchitecture.features.locations.domain.model.Location
import com.example.rickandmorty_cleanarchitecture.features.locations.navigator.LocationNavigator


class LocationDetailsViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    private val locationNavigator: LocationNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {


    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also { getLocations(it) }
    }

    val locations: LiveData<List<LocationDisplayable>> = _locations.map { locations ->
        locations.map { LocationDisplayable(it) }
    }

    private fun getLocations(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locations -> locationLiveData.value = locations }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onEpisodeClick(location: LocationDisplayable) {
        locationNavigator.openLocationDetailsScreen(location)
    }

}