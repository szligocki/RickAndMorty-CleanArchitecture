package com.example.rickandmorty_cleanarchitecture.features.episodes.navigation

import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.navigation.FragmentNavigator
import com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.rickandmorty_cleanarchitecture.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class EpisodeNavigationImplTest{

    @Test
    fun `WHEN openEpisodeDetailsScreen is called THAN invoke navigateTO method with appropriate action and episode model as arguments`(){
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigationImpl(fragmentNavigator)
        val episode = EpisodeDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()

        // when
        episodeNavigator.openEpisodeDetailsScreen(episode)

        // than
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_episodes_screen_to_episode_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe episode
    }

    @Test
    fun `WHEN openEpisodeDetailsScreen is called THAN invoke goBack method of FragmentNavigator`(){
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigationImpl(fragmentNavigator)


        // when
        episodeNavigator.goBack()

        // than
        verify { fragmentNavigator.goBack() }
    }
}