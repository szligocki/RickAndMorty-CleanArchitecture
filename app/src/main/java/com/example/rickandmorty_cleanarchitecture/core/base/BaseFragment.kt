package com.example.rickandmorty_cleanarchitecture.core.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BaseViewModel, S : ViewDataBinding>(
    private val viewModelId: Int,
    @LayoutRes layoutRes: Int
) : Fragment() {

    abstract val viewModel: T
    var binding: S? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)
        binding?.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.setVariable(viewModelId, viewModel)
            initViews(it)
        }
        initObservers()
        bindViewModelToLifecycle()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    open fun initViews(binding: S) {}

    open fun initObservers() {
        observeUiState()
        observeMessage()
    }

    open fun onIdleState() {}
    open fun onPendingState() {}

    protected fun showToast(it: String) {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(@StringRes stringRes: Int) {
        showToast(getString(stringRes))
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                UiState.Idle -> onIdleState()
                UiState.Pending -> onPendingState()
            }
        }
    }

}