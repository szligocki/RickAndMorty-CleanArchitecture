package com.example.rickandmorty_cleanarchitecture.features.episodes.detail.presentation

import com.example.rickandmorty_cleanarchitecture.BR
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import com.example.rickandmorty_cleanarchitecture.databinding.FragmentEpisodeDetailsBinding


class EpisodeDetailsFragment : BaseFragment<EpisodeDetailsViewModel, FragmentEpisodeDetailsBinding>(
    BR.viewModel,
    R.layout.fragment_episode_details
) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun initViews(binding: FragmentEpisodeDetailsBinding) {
        super.initViews(binding)
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacter()
    }

    private fun observeCharacter() {
        viewModel.episodes.observe(this) {
        }
    }
}