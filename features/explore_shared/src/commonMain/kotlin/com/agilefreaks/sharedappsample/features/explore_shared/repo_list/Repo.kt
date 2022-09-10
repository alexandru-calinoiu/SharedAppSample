package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import kotlinx.datetime.Instant

data class Repo(
    val name: String,
    val description: String,
    val primaryLanguage: String,
    val lastActivity: Instant?
)
