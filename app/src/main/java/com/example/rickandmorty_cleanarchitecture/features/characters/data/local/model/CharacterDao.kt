package com.example.rickandmorty_cleanarchitecture.features.characters.data.local.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacter(vararg character: CharacterCached)

    @Query("SELECT * FROM CharacterCached")
    suspend fun getCharacters() : List<CharacterCached>
}