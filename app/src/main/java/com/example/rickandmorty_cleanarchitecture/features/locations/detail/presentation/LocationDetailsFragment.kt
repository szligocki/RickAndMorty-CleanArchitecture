package com.example.rickandmorty_cleanarchitecture.features.locations.detail.presentation

import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment


class LocationDetailsFragment : BaseFragment<LocationDetailsViewModel>(R.layout.fragment_location_details) {

    override val viewModel : LocationDetailsViewModel by viewModel()

    companion object{
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

}