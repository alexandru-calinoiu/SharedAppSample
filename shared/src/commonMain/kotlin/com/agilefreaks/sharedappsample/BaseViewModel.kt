package com.agilefreaks.sharedappsample

import kotlinx.coroutines.CoroutineScope

interface ViewState

interface ViewEvent

interface ViewSideEffect

expect abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect> {
    val scope: CoroutineScope

    protected open fun onCleared()
}