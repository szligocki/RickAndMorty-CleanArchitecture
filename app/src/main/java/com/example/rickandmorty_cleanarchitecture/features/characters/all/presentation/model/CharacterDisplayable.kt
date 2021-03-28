package com.example.rickandmorty_cleanarchitecture.features.characters.all.presentation.model

import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character

data class CharacterDisplayable(
    val created: String?,
    val episode: List<String>?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val name: String?,
    val species: String?,
    val status: String?,
    val type: String?,
    val url: String?
) {
    constructor(character: Character) : this(
        created = character.created,
        episode = character.episode,
        gender = character.gender,
        id = character.id,
        image = character.image,
        name = character.name,
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )


}


