package com.agilefreaks.sharedappsample.features.explore_shared.repo_details

data class RepoDetails(
    val name: String,
    val description: String,
    val forkCount: Int,
    val hasIssuesEnabled: Boolean,
    val hasProjectsEnabled: Boolean,
    val hasWikiEnabled: Boolean,
    val homepageUrl: String,
    val labels: List<RepoLabel>
)

data class RepoLabel(
    val name: String,
    val description: String,
    val color: String
)

fun emptyRepoDetails() = RepoDetails(
    name = "",
    description = "",
    forkCount = 0,
    hasIssuesEnabled = false,
    hasProjectsEnabled = false,
    hasWikiEnabled = false,
    homepageUrl = "",
    labels = emptyList()
)