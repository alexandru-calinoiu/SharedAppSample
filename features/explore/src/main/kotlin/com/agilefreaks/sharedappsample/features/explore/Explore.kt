package com.agilefreaks.sharedappsample.features.explore

import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.agilefreaks.sharedappsample.AppDestinations
import com.agilefreaks.sharedappsample.features.explore.repo_details.repoDetailsModule
import com.agilefreaks.sharedappsample.features.explore.repo_list.repoListModule
import com.agilefreaks.sharedappsample.features.explore_shared.ExploreDestinations
import com.agilefreaks.sharedappsample.features.explore_shared.modules
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.navArgs
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.parseDetailsArgs
import org.koin.androidx.compose.getViewModel
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import com.agilefreaks.sharedappsample.features.explore.repo_details.Screen as RepoDetailsScreen
import com.agilefreaks.sharedappsample.features.explore.repo_details.ViewModel as RepoDetailsViewModel
import com.agilefreaks.sharedappsample.features.explore.repo_list.Screen as RepoListScreen
import com.agilefreaks.sharedappsample.features.explore.repo_list.ViewModel as RepoListViewModel
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Contract as RepoListContract

fun NavGraphBuilder.explore(navHostController: NavHostController) {
    navigation(
        startDestination = ExploreDestinations.Landing.route,
        route = AppDestinations.Features.explore
    ) {
        composable(route = ExploreDestinations.Landing.route) {
            val landingViewModel: RepoListViewModel = getViewModel()
            RepoListScreen(
                state = landingViewModel.viewState.collectAsState().value,
                effects = landingViewModel.effect,
                onNavigate = {
                    when (it) {
                        is RepoListContract.Effect.Navigation.ToDetails -> navHostController.navigate(
                            ExploreDestinations.Details().route(it.repoOwner, it.repoName)
                        )
                    }
                },
            ) { event -> landingViewModel.handleEvents(event) }
        }
        composable(
            route = ExploreDestinations.Details().route,
            arguments = ExploreDestinations.Details().navArgs()
        ) {
            val (repoOwner, repoName) = it.arguments.parseDetailsArgs()
            val detailsViewModel: RepoDetailsViewModel =
                getViewModel { parametersOf(repoOwner, repoName) }
            RepoDetailsScreen(
                state = detailsViewModel.viewState.collectAsState().value,
                effects = detailsViewModel.effect
            )
        }
    }
}

fun exploreModules(): List<Module> = listOf(repoListModule, repoDetailsModule) + modules()
