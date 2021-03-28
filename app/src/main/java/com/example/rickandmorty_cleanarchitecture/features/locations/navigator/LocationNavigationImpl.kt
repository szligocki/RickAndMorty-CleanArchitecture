package com.example.rickandmorty_cleanarchitecture.features.locations.navigator

import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.navigation.FragmentNavigator
import com.example.rickandmorty_cleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import com.example.rickandmorty_cleanarchitecture.features.locations.detail.presentation.LocationDetailsFragment

class LocationNavigationImpl(private val fragmentNavigator: FragmentNavigator) : LocationNavigator {

    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_locations_screen_to_location_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}