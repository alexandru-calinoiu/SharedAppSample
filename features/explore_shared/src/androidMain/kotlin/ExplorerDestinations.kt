package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import android.os.Bundle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.agilefreaks.sharedappsample.features.explore_shared.ExploreDestinations
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoName
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoOwner

fun ExploreDestinations.Details.navArgs() =
    listOf(navArgument(ExploreDestinations.Details.REPO_OWNER) { type = NavType.StringType },
        navArgument(ExploreDestinations.Details.REPO_NAME) { type = NavType.StringType })

data class DetailsArgs(val repoOwner: RepoOwner, val repoName: RepoName)

fun Bundle?.parseDetailsArgs() = DetailsArgs(
    repoOwner = checkNotNull(this?.getString(ExploreDestinations.Details.REPO_OWNER)),
    repoName = checkNotNull(this?.getString(ExploreDestinations.Details.REPO_NAME))
)
