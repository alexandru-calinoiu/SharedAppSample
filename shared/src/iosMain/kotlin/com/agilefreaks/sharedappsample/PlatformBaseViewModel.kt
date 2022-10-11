package com.agilefreaks.sharedappsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

actual abstract class PlatformBaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect> {
    private var hasCleared = false

    actual val scope: CoroutineScope by lazy {
        val result = CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

        if (hasCleared) {
            closeWithRuntimeException(result)
        }

        return@lazy result
    }

    protected actual open fun onCleared() {
    }

    // Make sure this is called on deinit from iOS
    @Suppress("unused")
    fun clear() {
        hasCleared = true
        closeWithRuntimeException(scope)
        onCleared()
    }

    companion object {
        private fun closeWithRuntimeException(obj: Any?) {
            if (obj is Closeable) {
                try {
                    obj.close()
                } catch (e: Exception) {
                    throw RuntimeException(e)
                }
            }
        }
    }
}