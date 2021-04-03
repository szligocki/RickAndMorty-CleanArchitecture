package com.example.rickandmorty_cleanarchitecture.features.locations.all.presentation.model

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty_cleanarchitecture.BR
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.base.BaseFragment
import com.example.rickandmorty_cleanarchitecture.databinding.FragmentLocationBinding
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationsViewModel, FragmentLocationBinding>(
    BR.viewModel,
    R.layout.fragment_location
) {

    override val viewModel: LocationsViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject();
    private val divider: DividerItemDecoration by inject()
    //    private val locationAdapter: LocationAdapter by inject()

    override fun initViews(binding: FragmentLocationBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentLocationBinding) {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
//            adapter = locationAdapter
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
        viewModel.locations.observe(this) {
        }
    }

}