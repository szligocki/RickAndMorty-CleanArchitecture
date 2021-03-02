package com.example.rickandmorty_cleanarchitecture.core.api.model

import com.example.rickandmorty_cleanarchitecture.core.api.model.episode.EpisodeRemote
import com.google.gson.annotations.SerializedName

data class EpisodesResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
) {
    companion object
}