package com.example.rickandmorty_cleanarchitecture.features.episodes.presentation

import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()

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
        viewModel.episodes.observe(this) {
        }
    }
}