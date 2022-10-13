package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import kotlinx.coroutines.launch

class ViewModel(private val viewerRepository: ViewerRepository) : BaseViewModel<State>() {
    override fun setInitialState(): State = State(repos = emptyList())

    fun fetchRepos() {
        scope.launch {
            val (response, error) = viewerRepository.repos()

            if (error != null) {
                setState { copy(repos = response?.response ?: emptyList()) }
            }
        }
    }
}