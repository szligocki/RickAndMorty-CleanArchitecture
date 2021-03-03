package com.example.rickandmorty_cleanarchitecture.core.api.model.character

import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}