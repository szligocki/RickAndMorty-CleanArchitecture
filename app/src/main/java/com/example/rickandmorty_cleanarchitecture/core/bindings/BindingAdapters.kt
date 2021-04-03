package com.example.rickandmorty_cleanarchitecture.core.bindings

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty_cleanarchitecture.core.adapter.BindableAdapter
import com.example.rickandmorty_cleanarchitecture.core.base.UiState

object BindingAdapters {

    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(progressBar: ProgressBar, uiState: UiState) {
        progressBar.visibility = if (uiState == UiState.Pending) View.VISIBLE else View.GONE
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
    }

    @BindingAdapter(value = ["app:imageUrl", "app:placeholder"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, imageUrl: String, @DrawableRes placeholder: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(placeholder)
            .into(imageView)
    }


}