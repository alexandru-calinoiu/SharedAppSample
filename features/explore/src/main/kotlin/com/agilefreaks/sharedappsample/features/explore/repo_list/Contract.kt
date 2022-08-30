package com.agilefreaks.sharedappsample.features.explore.repo_list

import com.agilefreaks.sharedappsample.ViewEvent
import com.agilefreaks.sharedappsample.ViewSideEffect
import com.agilefreaks.sharedappsample.ViewState
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Repo

class Contract {
    sealed class Event : ViewEvent

    data class State(
        val isLoading: Boolean = false,
        val repos: List<Repo> = emptyList()
    ) : ViewState

    sealed class Effect : ViewSideEffect
}