package com.agilefreaks.sharedappsample.features.explore.repo_details

import com.agilefreaks.sharedappsample.ViewEvent
import com.agilefreaks.sharedappsample.ViewSideEffect
import com.agilefreaks.sharedappsample.ViewState

class Contract {
    sealed class Event : ViewEvent

    data class State(val isLoading: Boolean = true) : ViewState

    sealed class Effect : ViewSideEffect
}