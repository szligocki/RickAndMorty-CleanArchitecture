package com.example.rickandmorty_cleanarchitecture.features.locations.domain.model

data class Location(
    val id: Int?,
    val created: String?,
    val dimension: String?,
    val name: String?,
    val residents: List<String>?,
    val type: String?,
    val url: String?
)