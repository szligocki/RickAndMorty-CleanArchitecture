package com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject

import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodesFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodesViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject();
    private val divider: DividerItemDecoration by inject()
//    private val episodeAdapter: EpisodeAdapter by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    private fun initRecycler() {
        with(recyclerView){
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
//            adapter = episodeAdapter
        }
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        progressBar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        progressBar.visibility = View.VISIBLE
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        with(recyclerView){
//            layoutManager = null
//            adapter = null
//        }
//    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
        }
    }
}