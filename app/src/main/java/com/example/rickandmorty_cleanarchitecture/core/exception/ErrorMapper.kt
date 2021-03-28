package com.example.rickandmorty_cleanarchitecture.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable) : String
}