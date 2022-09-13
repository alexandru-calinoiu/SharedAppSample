package com.agilefreaks.sharedappsample.features.explore.repo_details

import com.agilefreaks.sharedappsample.BaseViewModel

class ViewModel : BaseViewModel<Contract.Event, Contract.State, Contract.Effect>() {
    override fun setInitialState(): Contract.State = Contract.State()

    override fun handleEvents(event: Contract.Event) {
        TODO("Not yet implemented")
    }
}