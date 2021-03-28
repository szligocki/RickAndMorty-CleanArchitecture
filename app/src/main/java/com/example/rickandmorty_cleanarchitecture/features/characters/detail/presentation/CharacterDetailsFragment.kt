package com.example.rickandmorty_cleanarchitecture.features.characters.detail.presentation

import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment


class CharacterDetailsFragment : BaseFragment<CharacterDetailsViewModel>(R.layout.fragment_character_details) {

    override val viewModel : CharacterDetailsViewModel by viewModel()

    companion object{
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

}