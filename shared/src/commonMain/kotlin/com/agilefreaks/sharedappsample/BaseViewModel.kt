package com.agilefreaks.sharedappsample

import kotlinx.coroutines.CoroutineScope

interface ViewState

interface ViewEvent

interface ViewSideEffect

expect abstract class PlatformBaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect>() {
    val scope: CoroutineScope

    protected open fun onCleared()
}

abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect>:
    PlatformBaseViewModel<Event, UiState, Effect>() {
}


