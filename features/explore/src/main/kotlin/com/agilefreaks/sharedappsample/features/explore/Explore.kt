package com.agilefreaks.sharedappsample.features.explore

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.agilefreaks.sharedappsample.AppDestinations
import com.agilefreaks.sharedappsample.features.explore.repo_list.Screen
import com.agilefreaks.sharedappsample.features.explore.repo_list.ViewModel
import com.agilefreaks.sharedappsample.features.explore.repo_list.repoListModule
import com.agilefreaks.sharedappsample.features.explore_shared.modules
import org.koin.androidx.compose.getViewModel
import org.koin.core.module.Module

fun NavGraphBuilder.explore() {
    navigation(startDestination = AppDestinations.Explore.Landing.route, route = AppDestinations.Features.explore) {
        composable(route = AppDestinations.Explore.Landing.route) {
            val landingViewModel: ViewModel = getViewModel()
            Screen(state = landingViewModel.viewState.value)
        }
    }
}

fun exploreModules() : List<Module> = listOf(repoListModule) + modules()
