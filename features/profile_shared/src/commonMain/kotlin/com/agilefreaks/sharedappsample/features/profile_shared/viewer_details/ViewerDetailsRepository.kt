package com.agilefreaks.sharedappsample.features.profile_shared.viewer_details

import com.agilefreaks.sharedappsample.features.profile.dtos.ViewerProfileQuery
import com.apollographql.apollo3.ApolloClient
import com.github.kittinunf.result.Result

class ViewerDetailsRepository(private val client: ApolloClient) {
    suspend fun getUserDetails(): Result<ViewerDetails, Throwable> {
        val response = client.query(ViewerProfileQuery()).execute()

        return if (response.hasErrors()) {
            Result.failure(Exception(response.errors.toString()))
        } else {
            Result.success(
                response.data?.viewer?.toUserDetails() ?: emptyViewerDetails()
            )
        }
    }
}

private fun ViewerProfileQuery.Viewer.toUserDetails(): ViewerDetails =
    ViewerDetails(this.avatarUrl as String, this.bio)