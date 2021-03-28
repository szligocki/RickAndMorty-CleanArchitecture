package com.example.rickandmorty_cleanarchitecture.features.characters.navigation

import com.example.rickandmorty_cleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}