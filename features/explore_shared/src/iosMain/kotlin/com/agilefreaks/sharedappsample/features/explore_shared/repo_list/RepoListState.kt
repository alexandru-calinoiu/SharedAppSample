package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import com.agilefreaks.sharedappsample.ViewState

data class RepoListState(
    val repos: List<Repo>,
    val lastCursor: String? = null,
    val isLastPage: Boolean = false
) : ViewState