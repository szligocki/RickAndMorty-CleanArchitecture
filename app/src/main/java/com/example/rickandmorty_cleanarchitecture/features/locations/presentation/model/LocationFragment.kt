package com.example.rickandmorty_cleanarchitecture.features.locations.presentation.model

import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    override fun initViews() {
        super.initViews()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeEpisodes() {
        viewModel.locations.observe(this) {
        }
    }

}