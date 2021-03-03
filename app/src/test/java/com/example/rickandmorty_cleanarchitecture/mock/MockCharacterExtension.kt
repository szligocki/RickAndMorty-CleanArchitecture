package com.example.rickandmorty_cleanarchitecture.mock

import com.example.rickandmorty_cleanarchitecture.core.api.model.character.CharacterRemote
import com.example.rickandmorty_cleanarchitecture.core.api.model.character.CharactersResponse
import com.example.rickandmorty_cleanarchitecture.core.api.model.character.ResponseInfo
import com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model.CharacterCached
import org.jetbrains.annotations.TestOnly
import retrofit2.Response

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "Next Page",
    prev = "Prev Page"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    created = "01.01.2021",
    episode = listOf("Episode 1", "Episode 2"),
    gender = "gender",
    id = 1,
    image = "image url",
    name = "name",
    species = "species",
    status = "status",
    type = "type",
    url = "url"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    created = "02.02.2021",
    episode = listOf("Episode 1", "Episode 3"),
    gender = "gender",
    image = "iamge",
    name = "name",
    species = "species",
    status = "status",
    type = "type",
    url = "url"
)