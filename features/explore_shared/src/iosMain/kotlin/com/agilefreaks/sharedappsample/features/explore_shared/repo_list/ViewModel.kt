package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import kotlinx.coroutines.launch

class ViewModel(private val viewerRepository: ViewerRepository) : BaseViewModel<State>() {
    override fun setInitialState(): State = State(repos = emptyList(), lastCursor = null)

    fun fetchRepos(repo: Repo?) {
        if (viewState.value.isLastPage && isNotLast(repo)) {
            return
        }

        scope.launch {
            val (response, error) = viewerRepository.repos(
                pageSize = PAGE_SIZE,
                after = viewState.value.lastCursor
            )

            if (error != null) {
                val pageInfo = response?.pageInfo
                setState {
                    copy(
                        repos = viewState.value.repos + (response?.response ?: emptyList()),
                        lastCursor = pageInfo?.endCursor,
                        isLastPage = !(pageInfo?.hasNextPage ?: true)
                    )
                }
            }
        }
    }

    private fun isNotLast(repo: Repo?) = viewState.value.repos.last() != repo
}