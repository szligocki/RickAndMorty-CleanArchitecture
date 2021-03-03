package com.example.rickandmorty_cleanarchitecture.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model.CharacterCached
import com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model.CharacterDao
import com.example.rickandmorty_cleanarchitecture.features.episodes.data.local.EpisodeDao
import com.example.rickandmorty_cleanarchitecture.features.episodes.data.local.model.EpisodeCached

@Database(entities = [EpisodeCached::class, CharacterCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao

    abstract fun characterDao(): CharacterDao
}