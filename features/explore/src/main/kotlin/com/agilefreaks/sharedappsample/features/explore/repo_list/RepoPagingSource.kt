package com.agilefreaks.sharedappsample.features.explore.repo_list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.agilefreaks.sharedappsample.emptyPagedResponse
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Repo
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.ViewerRepository

class RepoPagingSource(private val viewerRepository: ViewerRepository) :
    PagingSource<String, Repo>() {
    override fun getRefreshKey(state: PagingState<String, Repo>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Repo> {
        val (response, error) = viewerRepository.repos(pageSize = params.loadSize, after = params.key)

        return if (error != null) {
            LoadResult.Error(error)
        } else {
            val (pageInfo, repos) = response ?: emptyPagedResponse()
            LoadResult.Page(repos, null, pageInfo.takeIf { it.hasNextPage }?.endCursor)
        }
    }
}
