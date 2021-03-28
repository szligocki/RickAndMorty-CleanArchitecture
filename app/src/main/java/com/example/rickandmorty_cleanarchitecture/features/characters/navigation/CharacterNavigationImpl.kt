package com.example.rickandmorty_cleanarchitecture.features.episodes.navigation

import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.navigation.FragmentNavigator
import com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.rickandmorty_cleanarchitecture.features.episodes.detail.presentation.EpisodeDetailsFragment

class EpisodeNavigationImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {

    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}