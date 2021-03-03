package com.example.rickandmorty_cleanarchitecture.features.characters.data.repository

import com.example.rickandmorty_cleanarchitecture.core.api.RickAndMortyApi
import com.example.rickandmorty_cleanarchitecture.core.api.model.character.CharactersResponse
import com.example.rickandmorty_cleanarchitecture.core.network.NetworkStateProvider
import com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model.CharacterCached
import com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model.CharacterDao
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.CharacterRepository
import com.example.rickandmorty_cleanarchitecture.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class CharactersRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN characters request THEN fetch characters from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }

        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: CharacterRepository =
            CharactersRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN characters request THEN save characters to local database`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }

        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: CharacterRepository =
            CharactersRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { characterDao.saveCharacter(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN fetch characters from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed = true)

        val characterDao = mockk<CharacterDao>() {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }

        val repository: CharacterRepository =
            CharactersRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { characterDao.getCharacters() }
    }

}