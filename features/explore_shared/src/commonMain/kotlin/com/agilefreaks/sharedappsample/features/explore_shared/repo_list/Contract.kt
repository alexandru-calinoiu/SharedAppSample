package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import com.agilefreaks.sharedappsample.ViewEvent
import com.agilefreaks.sharedappsample.ViewSideEffect

class Contract {
    sealed class Event : ViewEvent {
        data class SelectRepo(val repoOwner: RepoOwner, val repoName: RepoName) : Event()
    }

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            data class ToDetails(val repoOwner: RepoOwner, val repoName: RepoName) : Navigation()
        }
    }
}