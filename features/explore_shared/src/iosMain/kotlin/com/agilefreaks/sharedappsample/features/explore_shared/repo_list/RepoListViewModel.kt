package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import kotlinx.coroutines.launch

class RepoListViewModel(private val viewerRepository: ViewerRepository) :
    BaseViewModel<RepoListState>() {
    private var cursorBeingFetched:  String = ""

    override fun setInitialState(): RepoListState =
        RepoListState(repos = emptyList(), lastCursor = null)

    @Throws(Exception::class)
    fun fetchRepos(repo: Repo?) {
        if (viewState.value.isLastPage && isNotLast(repo) && currentCursorIsNotBeingFetched()) {
            return
        }

        scope.launch {
            val (response, error) = viewerRepository.repos(
                pageSize = PAGE_SIZE,
                after = viewState.value.lastCursor
            )

            println(viewState.value.lastCursor)

            if (error == null) {
                val pageInfo = response?.pageInfo
                setState {
                    copy(
                        repos = viewState.value.repos + (response?.response ?: emptyList()),
                        lastCursor = pageInfo?.endCursor,
                        isLastPage = !(pageInfo?.hasNextPage ?: true)
                    )
                }
            } else {
                throw Exception(error)
            }
        }
    }

    private fun isNotLast(repo: Repo?) = viewState.value.repos.last() != repo

    private fun currentCursorIsNotBeingFetched() = viewState.value.lastCursor != cursorBeingFetched
}