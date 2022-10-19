package com.agilefreaks.sharedappsample.features.profile_shared.viewer_details

data class ViewerDetails(
    val avatarUrl: String?,
    val bio: String?
)

fun emptyViewerDetails() = ViewerDetails("", "")