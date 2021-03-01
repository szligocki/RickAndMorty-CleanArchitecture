package com.example.rickandmorty_cleanarchitecture.features.locations.presentation.model

import com.example.rickandmorty_cleanarchitecture.features.locations.domain.model.Location

data class LocationDisplayable(
    val created: String?,
    val dimension: String?,
    val id: Int?,
    val name: String?,
    val residents: List<String>?,
    val type: String?,
    val url: String?
) {

    constructor(location: Location) : this(
        created = location.created,
        dimension = location.dimension,
        id = location.id,
        name = location.name,
        residents = location.residents,
        type = location.type,
        url = location.url
    )
}