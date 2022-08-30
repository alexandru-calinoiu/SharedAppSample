package com.agilefreaks.sharedappsample.features.explore.repo_list

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.agilefreaks.sharedappsample.BaseViewModel
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.ViewerRepository
import kotlinx.coroutines.launch

class ViewModel(private val viewerRepository: ViewerRepository) :
    BaseViewModel<Contract.Event, Contract.State, Contract.Effect>() {
    override fun setInitialState(): Contract.State = Contract.State()

    override fun handleEvents(event: Contract.Event) {
        TODO("Not yet implemented")
    }

    init {
        viewModelScope.launch {
            setState { copy(isLoading = true) }
            val result = viewerRepository.repos()
            setState { copy(isLoading = false) }
            when (result.isSuccess) {
                true ->
                    setState { copy(repos = result.getOrDefault(emptyList())) }
                false ->
                    Log.e("ExploreViewModel", result.exceptionOrNull()?.message ?: "")
            }
        }
    }
}