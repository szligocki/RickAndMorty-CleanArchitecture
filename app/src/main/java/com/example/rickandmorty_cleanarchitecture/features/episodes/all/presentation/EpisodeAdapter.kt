package com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Bindable
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.adapter.BindableAdapter
import com.example.rickandmorty_cleanarchitecture.databinding.ItemEpisodeBinding
import com.example.rickandmorty_cleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter : BindableAdapter<EpisodeDisplayable>, RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    val listener: ((EpisodeDisplayable) -> Unit)? = null
    private val episodes = mutableListOf<EpisodeDisplayable>()

    override fun setItems(item: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) this.episodes.clear()

        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

//    fun setEpisodes(episodes: List<EpisodeDisplayable>) {
//        if (episodes.isNotEmpty()) this.episodes.clear()
//
//        this.episodes.addAll(episodes)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EpisodeAdapter.EpisodeViewHolder {
        val inflate = LayoutInflater.from(parent.context)
//        val view = inflate.inflate(R.layout.item_episode, parent, false)
        val binding = ItemEpisodeBinding.inflate(inflate, parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun getItemCount() = episodes.size

    override fun onBindViewHolder(holder: EpisodeAdapter.EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    inner class EpisodeViewHolder(binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val binding = ItemEpisodeBinding.bind(itemView)

        fun bind(episode: EpisodeDisplayable) {
            with(binding) {
                binding.item = episode
                listener?.let { root.setOnClickListener { it(episode) } }
                binding.executePendingBindings()
            }
        }

    }




}