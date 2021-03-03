package com.example.rickandmorty_cleanarchitecture.core.di

import androidx.room.Room
import com.example.rickandmorty_cleanarchitecture.core.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "appDatabase"
        )
    }

    single { get<AppDatabase>().episodeDao() }
}