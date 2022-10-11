package com.agilefreaks.sharedappsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

actual abstract class PlatformBaseViewModel :
    ViewModel() {

    actual val scope = viewModelScope

    actual override fun onCleared() {
    }
}
