package com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int?,
    val created: String?,
    val episode: List<String>?,
    val gender: String?,
    val image: String?,
    val name: String?,
    val species: String?,
    val status: String?,
    val type: String?,
    val url: String?
) {
    constructor(character: Character) : this(
        id = character.id,
        created = character.created,
        episode = character.episode,
        gender = character.gender,
        image = character.image,
        name = character.name,
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        created = created,
        episode = episode,
        gender = gender,
        image = image,
        name = name,
        species = species,
        status = status,
        type = type,
        url = url
    )
}

