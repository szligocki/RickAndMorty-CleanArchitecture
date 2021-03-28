package com.example.rickandmorty_cleanarchitecture.features.characters.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_cleanarchitecture.core.base.BaseViewModel
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorMapper
import com.example.rickandmorty_cleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import com.example.rickandmorty_cleanarchitecture.features.characters.domain.GetCharactersUseCase
import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character
import com.example.rickandmorty_cleanarchitecture.features.characters.navigation.CharacterNavigator


class CharacterDetailsViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val characterNavigator: CharacterNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {


    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val characters: LiveData<List<CharacterDisplayable>> = _characters.map { characters ->
        characters.map { CharacterDisplayable(it) }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharactersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characters -> characterLiveData.value = characters }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onEpisodeClick(character: CharacterDisplayable) {
        characterNavigator.openCharacterDetailsScreen(character)
    }

}