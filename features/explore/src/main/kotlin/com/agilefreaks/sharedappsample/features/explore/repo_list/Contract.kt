package com.agilefreaks.sharedappsample.features.explore.repo_list

import androidx.paging.PagingData
import com.agilefreaks.sharedappsample.ViewEvent
import com.agilefreaks.sharedappsample.ViewSideEffect
import com.agilefreaks.sharedappsample.ViewState
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Repo
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoName
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoOwner
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Contract {
    sealed class Event : ViewEvent {
        data class SelectRepo(val repoOwner: RepoOwner, val repoName: RepoName): Event()
    }

    data class State(
        val repos: Flow<PagingData<Repo>> = flowOf(PagingData.empty())
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation: Effect() {
            data class ToDetails(val repoOwner: RepoOwner, val repoName: RepoName): Navigation()
        }
    }
}