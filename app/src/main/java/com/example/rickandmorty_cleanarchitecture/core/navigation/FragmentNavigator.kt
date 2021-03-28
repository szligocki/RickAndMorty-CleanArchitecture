package com.example.rickandmorty_cleanarchitecture.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes

interface FragmentNavigator {

    fun  navigateTo(
        @IdRes destinationId: Int,
        fragmentTransition: FragmentTransition? = null
    )

    fun <T> navigateTo(
        @IdRes destinationId: Int,
        param: Pair<String, T>? = null,
        fragmentTransition: FragmentTransition? = null
    )

    fun goBack(@IdRes destinationId: Int? = null, inclusive: Boolean = false)
    fun clearHistory()
}