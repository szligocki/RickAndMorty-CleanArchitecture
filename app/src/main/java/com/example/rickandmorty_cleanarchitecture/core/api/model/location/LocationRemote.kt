package com.example.rickandmorty_cleanarchitecture.core.api.model.location

import com.example.rickandmorty_cleanarchitecture.features.locations.domain.model.Location
import com.google.gson.annotations.SerializedName

data class LocationRemote(
    @SerializedName("id") val id: Int?,
    @SerializedName("created") val created: String?,
    @SerializedName("dimension") val dimension: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("residents") val residents: List<String>?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?
) {

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