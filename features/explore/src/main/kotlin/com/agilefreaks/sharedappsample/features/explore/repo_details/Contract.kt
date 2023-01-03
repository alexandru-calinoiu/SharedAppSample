package com.agilefreaks.sharedappsample.features.explore.repo_details

import com.agilefreaks.sharedappsample.ViewEvent
import com.agilefreaks.sharedappsample.ViewSideEffect
import com.agilefreaks.sharedappsample.ViewState
import com.agilefreaks.sharedappsample.features.explore_shared.repo_details.RepoDetails

class Contract {
    sealed class Event : ViewEvent

    data class State(
        val isLoading: Boolean = true,
        val details: RepoDetails
    ) : ViewState

    sealed class Effect : ViewSideEffect
}
