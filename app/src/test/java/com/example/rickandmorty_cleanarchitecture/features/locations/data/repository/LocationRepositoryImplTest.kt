package com.example.rickandmorty_cleanarchitecture.features.locations.data.repository

import com.example.rickandmorty_cleanarchitecture.core.api.RickAndMortyApi
import com.example.rickandmorty_cleanarchitecture.core.api.model.location.LocationsResponse
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorWrapper
import com.example.rickandmorty_cleanarchitecture.core.network.NetworkStateProvider
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.LocationRepository
import com.example.rickandmorty_cleanarchitecture.features.locations.data.local.LocationDao
import com.example.rickandmorty_cleanarchitecture.features.locations.data.local.model.LocationCached
import com.example.rickandmorty_cleanarchitecture.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class LocationRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from API`() {
        // given
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }

        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN locations request THEN save locations to local database`() {
        // given
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }

        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected  WHEN locations request THEN fetch locations from local database`() {
        // given
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val api = mockk<RickAndMortyApi>(relaxed = true)

        val locationDao = mockk<LocationDao>() {
            coEvery { getLocations() } returns listOf(LocationCached.mock(), LocationCached.mock())
        }

        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns false
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { locationDao.getLocations() }
    }


}