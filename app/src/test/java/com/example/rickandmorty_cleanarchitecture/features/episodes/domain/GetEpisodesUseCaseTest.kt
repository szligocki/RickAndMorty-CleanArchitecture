package com.example.rickandmorty_cleanarchitecture.features.episodes.domain

import android.provider.Settings
import com.example.rickandmorty_cleanarchitecture.features.episodes.EpisodeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class GetEpisodesUseCaseTest {

    @Test
    fun `when use case is invoke than execute getEpisodes method from repository`() {
        //given
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getEpisodes() }
    }
}