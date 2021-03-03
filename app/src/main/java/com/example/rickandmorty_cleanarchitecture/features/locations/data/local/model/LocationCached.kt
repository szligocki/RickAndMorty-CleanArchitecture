package com.example.rickandmorty_cleanarchitecture.features.locations.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty_cleanarchitecture.features.locations.domain.model.Location

@Entity
data class LocationCached(
    @PrimaryKey
    val id: Int?,
    val created: String?,
    val dimension: String?,
    val name: String?,
    val residents: List<String>?,
    val type: String?,
    val url: String?
) {

    constructor(location: Location) : this(
        location.id,
        location.created,
        location.dimension,
        location.name,
        location.residents,
        location.type,
        location.url
    )

    companion object

    fun toLocation() = Location(
        id = id,
        created = created,
        dimension = dimension,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}