package com.example.rickandmorty_cleanarchitecture.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}