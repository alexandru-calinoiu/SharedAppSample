package com.agilefreaks.sharedappsample.features.explore_shared

import com.agilefreaks.sharedappsample.AppDestinations
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoName
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.RepoOwner

class ExploreDestinations {
    object Landing : AppDestinations.Screen("landing")

    class Details : AppDestinations.Screen("details/{$REPO_OWNER}/{$REPO_NAME}") {
        companion object {
            const val REPO_OWNER = "repoOwner"
            const val REPO_NAME = "repoName"
        }

        fun route(repoOwner: RepoOwner, repoName: RepoName) = "details/$repoOwner/$repoName"
    }
}