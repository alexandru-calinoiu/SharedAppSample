package com.agilefreaks.sharedappsample.features.explore

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.agilefreaks.sharedappsample.AppDestinations
import com.agilefreaks.sharedappsample.features.explore.repo_details.repoDetailsModule
import com.agilefreaks.sharedappsample.features.explore.repo_list.repoListModule
import com.agilefreaks.sharedappsample.features.explore_shared.ExploreDestinations
import com.agilefreaks.sharedappsample.features.explore_shared.modules
import navArgs
import org.koin.androidx.compose.getViewModel
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import parseDetailsArgs
import com.agilefreaks.sharedappsample.features.explore.repo_details.Screen as RepoDetailsScreen
import com.agilefreaks.sharedappsample.features.explore.repo_details.ViewModel as RepoDetailsViewModel
import com.agilefreaks.sharedappsample.features.explore.repo_list.Contract as RepoListContract
import com.agilefreaks.sharedappsample.features.explore.repo_list.Screen as RepoListScreen
import com.agilefreaks.sharedappsample.features.explore.repo_list.ViewModel as RepoListViewModel

fun NavGraphBuilder.explore(navHostController: NavHostController) {
    navigation(
        startDestination = ExploreDestinations.Landing.route,
        route = AppDestinations.Features.explore
    ) {
        composable(route = ExploreDestinations.Landing.route) {
            val landingViewModel: RepoListViewModel = getViewModel()
            RepoListScreen(
                state = landingViewModel.viewState.value,
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
            val detailsViewModel: RepoDetailsViewModel = getViewModel { parametersOf(repoOwner, repoName) }
            RepoDetailsScreen(
                state = detailsViewModel.viewState.value,
                effects = detailsViewModel.effect
            ) {
                detailsViewModel.setEvent(it)
            }
        }
    }
}

fun exploreModules(): List<Module> = listOf(repoListModule, repoDetailsModule) + modules()
