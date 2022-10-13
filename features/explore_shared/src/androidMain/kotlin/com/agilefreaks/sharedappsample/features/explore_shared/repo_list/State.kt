package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import androidx.paging.PagingData
import com.agilefreaks.sharedappsample.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class State(
    val repos: Flow<PagingData<Repo>> = flowOf(PagingData.empty())
) : ViewState