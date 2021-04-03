package com.example.rickandmorty_cleanarchitecture.features.characters.detail.presentation


import com.example.rickandmorty_cleanarchitecture.BR
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import com.example.rickandmorty_cleanarchitecture.databinding.FragmentCharacterDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterDetailsFragment : BaseFragment<CharacterDetailsViewModel, FragmentCharacterDetailsBinding>(
    BR.viewModel,
    R.layout.fragment_character_details) {

    override val viewModel : CharacterDetailsViewModel by viewModel()

    companion object{
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun initViews(binding: FragmentCharacterDetailsBinding) {
        super.initViews(binding)
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacter()
    }
    private fun observeCharacter() {
        viewModel.characters.observe(this) {
        }
    }
}