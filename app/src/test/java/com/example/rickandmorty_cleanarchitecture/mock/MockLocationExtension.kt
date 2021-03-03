package com.example.rickandmorty_cleanarchitecture.mock

import com.example.rickandmorty_cleanarchitecture.core.api.model.location.LocationRemote
import com.example.rickandmorty_cleanarchitecture.core.api.model.location.LocationsResponse
import com.example.rickandmorty_cleanarchitecture.core.api.model.location.ResponseInfo
import com.example.rickandmorty_cleanarchitecture.features.locations.data.local.model.LocationCached
import org.jetbrains.annotations.TestOnly
import org.junit.Test

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "Next page",
    prev = "Prev page"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    created = "02.01.2021",
    dimension = "dimension",
    name = "name",
    residents = listOf("residents 1", "residents 2"),
    type = "type",
    url = "url"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(LocationRemote.mock(), LocationRemote.mock())
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    created = "created",
    dimension = "dimension",
    name = "name",
    residents = listOf("residents 1", "residents 2"),
    type = "type",
    url = "url"

)
