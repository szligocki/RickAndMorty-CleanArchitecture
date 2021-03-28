package com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_cleanarchitecture.core.base.BaseViewModel
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorMapper
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.GetEpisodesUseCase
import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.model.Episode
import com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {


    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> = _episodes.map { episodes ->
        episodes.map { EpisodeDisplayable(it) }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodes -> episodeLiveData.value = episodes }
            result.onFailure { handleFailure(it) }
        }
    }


}