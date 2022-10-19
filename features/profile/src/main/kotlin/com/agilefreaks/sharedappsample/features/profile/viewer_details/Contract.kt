package com.agilefreaks.sharedappsample.features.profile.viewer_details

import com.agilefreaks.sharedappsample.ViewEvent
import com.agilefreaks.sharedappsample.ViewSideEffect
import com.agilefreaks.sharedappsample.ViewState
import com.agilefreaks.sharedappsample.features.profile_shared.viewer_details.ViewerDetails

class Contract {
    sealed class Event : ViewEvent

    data class State(
        val isLoading: Boolean = true,
        val userProfileDetails: ViewerDetails = ViewerDetails("", "")
    ) : ViewState

    sealed class Effect : ViewSideEffect
}