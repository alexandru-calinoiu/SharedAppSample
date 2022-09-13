package com.agilefreaks.sharedappsample.features.explore

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.agilefreaks.sharedappsample.AppDestinations
import com.agilefreaks.sharedappsample.features.explore.repo_details.repoDetailsModule
import com.agilefreaks.sharedappsample.features.explore.repo_list.Contract as RepoListContract
import com.agilefreaks.sharedappsample.features.explore.repo_list.repoListModule
import com.agilefreaks.sharedappsample.features.explore_shared.modules
import org.koin.androidx.compose.getViewModel
import org.koin.core.module.Module
import com.agilefreaks.sharedappsample.features.explore.repo_details.Screen as RepoDetailsScreen
import com.agilefreaks.sharedappsample.features.explore.repo_details.ViewModel as RepoDetailsViewModel
import com.agilefreaks.sharedappsample.features.explore.repo_list.Screen as RepoListScreen
import com.agilefreaks.sharedappsample.features.explore.repo_list.ViewModel as RepoListViewModel

fun NavGraphBuilder.explore(navHostController: NavHostController) {
    navigation(
        startDestination = AppDestinations.Explore.Landing.route,
        route = AppDestinations.Features.explore
    ) {
        composable(route = AppDestinations.Explore.Landing.route) {
            val landingViewModel: RepoListViewModel = getViewModel()
            RepoListScreen(
                state = landingViewModel.viewState.value,
                effects = landingViewModel.effect,
                onNavigate = {
                    when(it) {
                        is RepoListContract.Effect.Navigation.ToDetails -> navHostController.navigate(AppDestinations.Explore.Details.route)
                    }
                }
            ) { event -> landingViewModel.handleEvents(event) }
        }
        composable(route = AppDestinations.Explore.Details.route) {
            val detailsViewModel: RepoDetailsViewModel = getViewModel()
            RepoDetailsScreen(state = detailsViewModel.viewState.value)
        }
    }
}

fun exploreModules(): List<Module> = listOf(repoListModule, repoDetailsModule) + modules()
