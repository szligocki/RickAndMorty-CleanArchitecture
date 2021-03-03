package com.example.rickandmorty_cleanarchitecture.features.characters.domain

import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}