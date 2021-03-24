package com.example.rickandmorty_cleanarchitecture.features.characters.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_cleanarchitecture.core.base.BaseViewModel
import com.example.rickandmorty_cleanarchitecture.features.characters.domain.GetCharactersUseCase
import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character
import com.example.rickandmorty_cleanarchitecture.features.characters.presentation.model.CharacterDisplayable

class CharacterViewModel(private val getCharactersUseCase: GetCharactersUseCase) : BaseViewModel() {

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

}