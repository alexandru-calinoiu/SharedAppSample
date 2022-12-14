package com.agilefreaks.sharedappsample.features.explore.repo_list

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.BaseViewModel
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Repo
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.State
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.ViewerRepository
import kotlinx.coroutines.flow.Flow

class ViewModel(private val viewerRepository: ViewerRepository) : BaseViewModel<State>() {
    override fun setInitialState(): State = State(repos = fetchRepos())

    private fun fetchRepos(): Flow<PagingData<Repo>> =
        Pager(PagingConfig(pageSize = PAGE_SIZE)) {
            RepoPagingSource(viewerRepository)
        }.flow.cachedIn(viewModelScope)
}
