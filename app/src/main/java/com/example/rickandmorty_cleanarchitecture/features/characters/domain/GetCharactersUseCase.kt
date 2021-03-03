package com.example.rickandmorty_cleanarchitecture.features.characters.domain

import com.example.rickandmorty_cleanarchitecture.core.base.UseCase
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.CharacterRepository
import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository):
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit): List<Character> = characterRepository.getCharacters()
}