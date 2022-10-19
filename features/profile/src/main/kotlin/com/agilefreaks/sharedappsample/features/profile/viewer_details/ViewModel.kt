package com.agilefreaks.sharedappsample.features.profile.viewer_details

import androidx.lifecycle.viewModelScope
import com.agilefreaks.sharedappsample.BaseViewModel
import com.agilefreaks.sharedappsample.features.profile.viewer_details.Contract
import com.agilefreaks.sharedappsample.features.profile_shared.viewer_details.ViewerDetailsRepository
import com.agilefreaks.sharedappsample.features.profile_shared.viewer_details.emptyViewerDetails
import kotlinx.coroutines.launch

class ViewModel(private val viewerDetailsRepository: ViewerDetailsRepository) :
    BaseViewModel<Contract.Event, Contract.State, Contract.Effect>() {

    init {
        fetchUserProfileDetails()
    }

    override fun setInitialState(): Contract.State = Contract.State()

    override fun handleEvents(event: Contract.Event) {
    }

    private fun fetchUserProfileDetails() {
        viewModelScope.launch {
            val (result, _) = viewerDetailsRepository.getUserDetails()
            setState {
                copy(
                    isLoading = false,
                    userProfileDetails = result ?: emptyViewerDetails()
                )
            }
        }
    }
}
