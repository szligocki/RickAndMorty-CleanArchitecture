package com.example.rickandmorty_cleanarchitecture.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}
