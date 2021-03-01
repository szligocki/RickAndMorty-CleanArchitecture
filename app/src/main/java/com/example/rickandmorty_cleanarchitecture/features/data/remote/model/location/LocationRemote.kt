package com.example.rickandmorty_cleanarchitecture.features.data.remote.model.location

import com.example.rickandmorty_cleanarchitecture.features.locations.domain.model.Location
import com.google.gson.annotations.SerializedName

data class LocationRemote(
    @SerializedName("created") val created: String?,
    @SerializedName("dimension") val dimension: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("residents") val residents: List<String>?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?
) {

    fun toLocation() = Location(
        created = created,
        dimension = dimension,
        id = id,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}