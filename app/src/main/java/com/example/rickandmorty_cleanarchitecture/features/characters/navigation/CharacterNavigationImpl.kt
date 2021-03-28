package com.example.rickandmorty_cleanarchitecture.features.characters.navigation

import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.navigation.FragmentNavigator
import com.example.rickandmorty_cleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import com.example.rickandmorty_cleanarchitecture.features.characters.detail.presentation.CharacterDetailsFragment

class CharacterNavigationImpl(private val fragmentNavigator: FragmentNavigator) :
    CharacterNavigator {

    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_character_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}