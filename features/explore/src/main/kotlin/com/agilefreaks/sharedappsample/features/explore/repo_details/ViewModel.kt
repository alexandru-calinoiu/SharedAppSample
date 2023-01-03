package com.agilefreaks.sharedappsample.features.explore.repo_details

import androidx.lifecycle.viewModelScope
import com.agilefreaks.sharedappsample.BaseViewModel
import com.agilefreaks.sharedappsample.features.explore_shared.repo_details.RepoDetailsRepository
import com.agilefreaks.sharedappsample.features.explore_shared.repo_details.emptyRepoDetails
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoName
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoOwner
import kotlinx.coroutines.launch

class ViewModel(
    private val repoDetailsRepository: RepoDetailsRepository,
    private val repoOwner: RepoOwner,
    private val repoName: RepoName
) : BaseViewModel<Contract.Event, Contract.State, Contract.Effect>() {

    override fun setInitialState(): Contract.State =
        Contract.State(
            isLoading = true,
            details = emptyRepoDetails()
        )

    override fun handleEvents(event: Contract.Event) {
        // no events to handle
    }

    private fun fetchRepoDetails() {
        viewModelScope.launch {
            val (response, _) = repoDetailsRepository.repoDetails(repoOwner, repoName)
            setState {
                copy(
                    isLoading = false,
                    details = response ?: emptyRepoDetails()
                )
            }
        }
    }

    init {
        fetchRepoDetails()
    }
}
