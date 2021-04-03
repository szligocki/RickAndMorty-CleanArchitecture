package com.example.rickandmorty_cleanarchitecture.core.adapter

interface BindableAdapter<T> {
    fun setItems(item: List<T>)
}