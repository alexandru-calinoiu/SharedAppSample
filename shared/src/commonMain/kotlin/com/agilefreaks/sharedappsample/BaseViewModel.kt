package com.agilefreaks.sharedappsample

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

interface ViewState

interface ViewEvent

interface ViewSideEffect

expect abstract class PlatformBaseViewModel() {
    val scope: CoroutineScope

    protected open fun onCleared()
}

interface Closeable {
    fun close()
}

abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect> :
    PlatformBaseViewModel() {

    private val initialState: UiState by lazy { setInitialState() }
    abstract fun setInitialState(): UiState

    private val _viewState: MutableStateFlow<UiState> = MutableStateFlow(initialState)
    val viewState: StateFlow<UiState> = _viewState

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    fun setEvent(event: Event) {
        scope.launch { _event.emit(event) }
    }

    protected fun setState(reducer: UiState.() -> UiState) {
        scope.launch {
            _viewState.emit(viewState.value.reducer())
        }
    }

    fun setStateObserver(onStateChanged: ((UiState) -> Unit)) : Closeable {
        val job = Job()

        _viewState.onEach {
            onStateChanged(it)
        }.launchIn(scope.plus(job))

        return object : Closeable {
            override fun close() {
                job.cancel()
            }
        }
    }

    private fun subscribeToEvents() {
        scope.launch {
            _event.collect {
                handleEvents(it)
            }
        }
    }

    abstract fun handleEvents(event: Event)

    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        scope.launch { _effect.send(effectValue) }
    }
}


