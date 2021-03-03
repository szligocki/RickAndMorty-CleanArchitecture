package com.example.rickandmorty_cleanarchitecture.core.api.model.location

import com.google.gson.annotations.SerializedName

data class LocationsResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationRemote>
) {
    companion object
}