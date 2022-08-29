package com.agilefreaks.sharedappsample.features.explore.repository_list

import androidx.lifecycle.viewModelScope
import com.agilefreaks.sharedappsample.BaseViewModel
import com.agilefreaks.sharedappsample.features.explore_shared.GreetingRepository
import kotlinx.coroutines.launch

class ViewModel(private val greetingRepository: GreetingRepository) : BaseViewModel<Contract.Event, Contract.State, Contract.Effect>() {
    override fun setInitialState(): Contract.State = Contract.State()

    override fun handleEvents(event: Contract.Event) {
        TODO("Not yet implemented")
    }

    init {
        viewModelScope.launch {
            setState { copy(isLoading = true) }
            setState { copy(isLoading = false, greeting = greetingRepository.greeting()) }
        }
    }
}