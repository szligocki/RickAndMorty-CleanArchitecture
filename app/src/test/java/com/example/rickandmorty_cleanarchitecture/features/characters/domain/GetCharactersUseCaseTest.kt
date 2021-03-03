package com.example.rickandmorty_cleanarchitecture.features.characters.domain

import com.example.rickandmorty_cleanarchitecture.features.episodes.domain.CharacterRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test

internal class GetCharactersUseCaseTest {

    @Test
    fun `when use case is invoke than execute getCharacters method from repository`() {
        //given
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //than
        coVerify { repository.getCharacters() }
    }
}