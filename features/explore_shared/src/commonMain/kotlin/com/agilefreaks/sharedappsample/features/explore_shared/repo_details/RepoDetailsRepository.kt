package com.agilefreaks.sharedappsample.features.explore_shared.repo_details

import com.agilefreaks.sharedappsample.features.explore.dtos.RepositoryDetailsQuery
import com.apollographql.apollo3.ApolloClient
import com.github.kittinunf.result.Result

class RepoDetailsRepository(private val client: ApolloClient) {
    suspend fun repoDetails(owner: String, name: String): Result<RepoDetails, Throwable> {
        val response = client
            .query(RepositoryDetailsQuery(owner, name))
            .execute()

        return if (response.hasErrors()) {
            Result.failure(Exception(response.errors.toString()))
        } else {
            Result.success(
                response.data?.repository?.toRepoDetails() ?: emptyRepoDetails()
            )
        }
    }

    private fun RepositoryDetailsQuery.Repository.toRepoDetails(): RepoDetails =
        RepoDetails(
            name = this.name,
            description = this.description ?: "",
            forkCount = this.forkCount,
            hasIssuesEnabled = this.hasIssuesEnabled,
            hasProjectsEnabled = this.hasProjectsEnabled,
            hasWikiEnabled = this.hasWikiEnabled,
            homepageUrl = this.homepageUrl.toString(),
            labels = this.labels?.nodes?.map {
                RepoLabel(
                    name = it?.name ?: "",
                    description = it?.description ?: "",
                    color = it?.color ?: ""
                )
            } ?: emptyList()
        )
}
