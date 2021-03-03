package com.example.rickandmorty_cleanarchitecture.features.characters.data.repository

import com.example.rickandmorty_cleanarchitecture.core.api.RickAndMortyApi
import com.example.rickandmorty_cleanarchitecture.core.network.NetworkStateProvider
import com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model.CharacterCached
import com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model.CharacterDao
import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.CharacterRepository

class CharactersRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {


    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote()
                .also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters()
            .map { it.toCharacter() }
    }

    private suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let {
                characterDao.saveCharacter(*it)
            }
    }
}