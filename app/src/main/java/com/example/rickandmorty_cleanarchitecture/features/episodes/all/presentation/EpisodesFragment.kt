package com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty_cleanarchitecture.BR
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import com.example.rickandmorty_cleanarchitecture.databinding.FragmentEpisodeBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodesFragment : BaseFragment<EpisodesViewModel, FragmentEpisodeBinding>(
    BR.viewModel,
    R.layout.fragment_episode
) {

    override val viewModel: EpisodesViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject();
    private val divider: DividerItemDecoration by inject()
    private val episodeAdapter: EpisodeAdapter by inject()


    override fun initViews(binding: FragmentEpisodeBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentEpisodeBinding) {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = episodeAdapter
        }
    }

//    override fun initObservers() {
//        super.initObservers()
//        observeEpisodes()
//    }


//    private fun observeEpisodes() {
//        viewModel.episodes.observe(this) {
//            episodeAdapter.setEpisodes(it)
//        }
//    }
}