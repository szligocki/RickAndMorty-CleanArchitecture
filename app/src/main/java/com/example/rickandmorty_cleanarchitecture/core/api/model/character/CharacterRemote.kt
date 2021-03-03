package com.example.rickandmorty_cleanarchitecture.core.api.model.character

import com.example.rickandmorty_cleanarchitecture.features.characters.domain.model.Character
import com.google.gson.annotations.SerializedName


data class CharacterRemote(
    @SerializedName("created") val created: String?,
    @SerializedName("episode") val episode: List<String>?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("species") val species: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?
) {
    companion object

    fun toCharacter() = Character(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        name = name,
        species = species,
        status = status,
        type = type,
        url = url
    )
}
