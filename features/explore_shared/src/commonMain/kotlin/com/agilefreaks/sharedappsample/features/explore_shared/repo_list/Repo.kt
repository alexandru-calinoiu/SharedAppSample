package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import kotlinx.datetime.Instant

typealias RepoOwner = String
typealias RepoName = String

data class Repo(
    val owner: RepoOwner,
    val name: RepoName,
    val description: String,
    val primaryLanguage: String,
    val lastActivity: Instant?
)
