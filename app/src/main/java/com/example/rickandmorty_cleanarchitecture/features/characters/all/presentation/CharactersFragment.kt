package com.example.rickandmorty_cleanarchitecture.features.characters.presentation

import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

    override fun initViews() {
        super.initViews()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
        }
    }

}