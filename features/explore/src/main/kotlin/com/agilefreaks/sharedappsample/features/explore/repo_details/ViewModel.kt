package com.agilefreaks.sharedappsample.features.explore.repo_details

import com.agilefreaks.sharedappsample.BaseViewModel
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoName
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoOwner

class ViewModel(
    private val repoOwner: RepoOwner,
    private val repoName: RepoName
) :
    BaseViewModel<Contract.Event, Contract.State, Contract.Effect>() {
    
    override fun setInitialState(): Contract.State = Contract.State()

    override fun handleEvents(event: Contract.Event) {
        TODO()
    }

    init {
        setState { copy(isLoading = false) }
    }

}