package com.example.rickandmorty_cleanarchitecture.features.episodes.detail.presentation

import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment


class EpisodeDetailsFragment : BaseFragment<EpisodeDetailsViewModel>(R.layout.fragment_episode_details) {

    override val viewModel : EpisodeDetailsViewModel by viewModel()

    companion object{
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

}