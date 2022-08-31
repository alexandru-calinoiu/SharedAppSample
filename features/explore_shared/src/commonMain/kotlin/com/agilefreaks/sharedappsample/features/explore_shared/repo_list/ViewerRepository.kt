package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import com.agilefreaks.sharedappsample.features.explore.dtos.ViewerRepositoriesQuery
import com.apollographql.apollo3.ApolloClient
import         com.github.kittinunf.result.Result

class ViewerRepository(private val client: ApolloClient) {
    suspend fun repos(): Result<List<Repo>, Throwable> {
        val response = client
            .query(ViewerRepositoriesQuery())
            .execute()

        return if (response.hasErrors()) {
            Result.failure(Exception(response.errors.toString()))
        } else {
            Result.success(response.data?.viewer?.repositories?.edges?.toRepos() ?: emptyList())
        }
    }

    private fun List<ViewerRepositoriesQuery.Edge?>.toRepos(): List<Repo> =
        this
            .mapNotNull { it?.node }
            .map { Repo(name = it.name ) }
}