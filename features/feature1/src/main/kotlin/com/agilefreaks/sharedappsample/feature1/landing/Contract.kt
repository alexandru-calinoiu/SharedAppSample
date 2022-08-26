package com.agilefreaks.sharedappsample.feature1.landing

import com.agilefreaks.sharedappsample.ViewEvent
import com.agilefreaks.sharedappsample.ViewSideEffect
import com.agilefreaks.sharedappsample.ViewState

class Contract {
    sealed class Event : ViewEvent {
    }

    data class State(
        val isLoading: Boolean = false,
        val greeting: String = ""
    ) : ViewState

    sealed class Effect : ViewSideEffect {
    }
}