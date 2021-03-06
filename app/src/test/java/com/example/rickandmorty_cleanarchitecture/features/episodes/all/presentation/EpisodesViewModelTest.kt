package com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_cleanarchitecture.core.base.UiState
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorMapper
import com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.GetEpisodesUseCase
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.model.Episode
import com.example.rickandmorty_cleanarchitecture.features.episodes.navigation.EpisodeNavigator
import com.example.rickandmorty_cleanarchitecture.mock.mock
import com.example.rickandmorty_cleanarchitecture.utils.ViewModelTest
import com.example.rickandmorty_cleanarchitecture.utils.getOrAwaitValue
import com.example.rickandmorty_cleanarchitecture.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.Rule
import org.junit.Test

internal class EpisodesViewModelTest : ViewModelTest() {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `WHEN episode is clicked THAN open episode details screen`() {
        // given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)
        val episode = EpisodeDisplayable.mock()

        // when
        viewModel.onEpisodeClick(episode)

        // than
        verify { episodeNavigator.openEpisodeDetailsScreen(episode) }
    }


    @Test
    fun `WHEN episode live data is observed THEN set pending state`() {
        // given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        // when
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN episode live data is observed THEN invoke us case to get episodes`() {
        // given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        // when
        viewModel.episodes.observeForTesting()

        // then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN episode live data is observed THEN set idle state AND set result in live data`() {
        // given
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)

        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }

        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        // when
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.code shouldBe episode.code
        }
    }


    @Test
    fun `GIVEN use case result is failure WHEN episode live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)

        val throwable = Throwable("Ops... Something wnet wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }

        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        // when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle

        verify { observer.onChanged(throwable.message) }
    }
}