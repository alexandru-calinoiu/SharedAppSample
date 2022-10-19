package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import com.agilefreaks.sharedappsample.BaseViewModel
import com.agilefreaks.sharedappsample.ViewState

abstract class BaseViewModel<VS : ViewState> :
    BaseViewModel<Contract.Event, VS, Contract.Effect>() {

    companion object {
        const val PAGE_SIZE = 20
    }

    override fun handleEvents(event: Contract.Event) {
        when (event) {
            is Contract.Event.SelectRepo -> navigateToDetails(event.repoOwner, event.repoName)
        }
    }

    private fun navigateToDetails(repoOwner: String, repoName: String) {
        setEffect {
            Contract.Effect.Navigation.ToDetails(repoOwner, repoName)
        }
    }
}