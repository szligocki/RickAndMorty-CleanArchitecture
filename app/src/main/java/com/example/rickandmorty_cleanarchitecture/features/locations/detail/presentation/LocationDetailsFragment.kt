package com.example.rickandmorty_cleanarchitecture.features.locations.detail.presentation

import com.example.rickandmorty_cleanarchitecture.BR
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import com.example.rickandmorty_cleanarchitecture.databinding.FragmentCharacterDetailsBinding
import com.example.rickandmorty_cleanarchitecture.databinding.FragmentLocationDetailsBinding


class LocationDetailsFragment : BaseFragment<LocationDetailsViewModel, FragmentLocationDetailsBinding>(
    BR.viewModel,
    R.layout.fragment_location_details) {

    override val viewModel : LocationDetailsViewModel by viewModel()

    companion object{
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun initViews(binding: FragmentLocationDetailsBinding) {
        super.initViews(binding)
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacter()
    }

    private fun observeCharacter() {
        viewModel.locations.observe(this) {
        }
    }
}