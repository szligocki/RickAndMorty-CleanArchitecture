package com.example.rickandmorty_cleanarchitecture.features.characters.domain.model

data class Character(
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
)