package com.example.rickandmorty_cleanarchitecture.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable) : Throwable
}