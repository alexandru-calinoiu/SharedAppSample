package com.agilefreaks.sharedappsample.features.explore

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.agilefreaks.sharedappsample.AppDestinations
import com.agilefreaks.sharedappsample.features.explore.repository_list.Screen
import com.agilefreaks.sharedappsample.features.explore.repository_list.ViewModel
import com.agilefreaks.sharedappsample.features.explore_shared.GreetingRepository

fun NavGraphBuilder.explore() {
    navigation(startDestination = AppDestinations.Explore.Landing.route, route = AppDestinations.Features.explore) {
        composable(route = AppDestinations.Explore.Landing.route) {
            val landingViewModel = ViewModel(GreetingRepository())
            Screen(state = landingViewModel.viewState.value)
        }
    }
}
