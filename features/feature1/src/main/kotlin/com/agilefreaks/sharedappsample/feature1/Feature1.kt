package com.agilefreaks.sharedappsample.feature1

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.agilefreaks.sharedappsample.AppDestinations
import com.agilefreaks.sharedappsample.feature1.landing.Screen
import com.agilefreaks.sharedappsample.feature1.landing.ViewModel
import com.agilefreaks.sharedappsample.feature1_shared.GreetingRepository

fun NavGraphBuilder.feature1() {
    navigation(startDestination = AppDestinations.Feature1.Landing.route, route = AppDestinations.Features.feature1) {
        composable(route = AppDestinations.Feature1.Landing.route) {
            val landingViewModel = ViewModel(GreetingRepository())
            Screen(state = landingViewModel.viewState.value)
        }
    }
}
