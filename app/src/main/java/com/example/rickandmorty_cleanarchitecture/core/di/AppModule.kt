package com.example.rickandmorty_cleanarchitecture.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty_cleanarchitecture.R
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorMapper
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorMapperImpl
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorWrapper
import com.example.rickandmorty_cleanarchitecture.core.exception.ErrorWrapperImpl
import com.example.rickandmorty_cleanarchitecture.core.navigation.FragmentNavigator
import com.example.rickandmorty_cleanarchitecture.core.navigation.FragmentNavigatorImpl
import com.example.rickandmorty_cleanarchitecture.core.network.NetworkStateProvider
import com.example.rickandmorty_cleanarchitecture.core.network.NetworkStateProviderImpl
import com.example.rickandmorty_cleanarchitecture.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory<RecyclerView.LayoutManager> { LinearLayoutManager(androidContext()) }
    factory { DividerItemDecoration(androidContext(), DividerItemDecoration.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.characters_screen,
            defaultNavOptions = get()
        )
    }
    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_close_enter }
            anim { popExit = R.anim.fragment_close_exit }
        }
    }
}