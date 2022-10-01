package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import com.agilefreaks.sharedappsample.PagedResponse
import com.agilefreaks.sharedappsample.apollo.toOptional
import com.agilefreaks.sharedappsample.emptyPagedResponse
import com.agilefreaks.sharedappsample.features.explore.dtos.ViewerRepositoriesQuery
import com.apollographql.apollo3.ApolloClient
import com.github.kittinunf.result.Result

interface ViewerRepository {
    suspend fun repos(
        pageSize: Int = 30,
        after: String? = null
    ): Result<PagedResponse<Repo>, Throwable>
}

class ViewerRepositoryImpl(private val client: ApolloClient) : ViewerRepository {
    override suspend fun repos(
        pageSize: Int,
        after: String?
    ): Result<PagedResponse<Repo>, Throwable> {
        val response = client
            .query(ViewerRepositoriesQuery(pageSize.toOptional(), after.toOptional()))
            .execute()

        return if (response.hasErrors()) {
            Result.failure(Exception(response.errors.toString()))
        } else {
            Result.success(
                response.data?.viewer?.repositories?.toPagedResponse() ?: emptyPagedResponse()
            )
        }
    }

    private fun ViewerRepositoriesQuery.Repositories.toPagedResponse(): PagedResponse<Repo> =
        PagedResponse(
            pageInfo = this.pageInfo.toPageInfo(),
            response = this.edges?.toRepos() ?: emptyList()
        )

    private fun ViewerRepositoriesQuery.PageInfo.toPageInfo(): com.agilefreaks.sharedappsample.PageInfo =
        com.agilefreaks.sharedappsample.PageInfo(
            endCursor = this.endCursor,
            hasNextPage = this.hasNextPage,
        )

    private fun List<ViewerRepositoriesQuery.Edge?>.toRepos(): List<Repo> =
        this
            .mapNotNull { it?.node }
            .map {
                Repo(
                    owner = it.owner.login,
                    name = it.name,
                    description = it.description ?: "",
                    primaryLanguage = it.primaryLanguage?.name ?: "",
                    lastActivity = it.pushedAt
                )
            }
}
