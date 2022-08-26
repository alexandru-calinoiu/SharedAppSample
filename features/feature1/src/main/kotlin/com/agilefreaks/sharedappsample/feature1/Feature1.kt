package com.agilefreaks.sharedappsample.feature1

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.agilefreaks.sharedappsample.AppDestinations

fun NavGraphBuilder.feature1() {
    navigation(startDestination = AppDestinations.Feature1.Landing.route, route = AppDestinations.Features.feature1) {
        composable(route = AppDestinations.Feature1.Landing.route) {
            LandingScreen()
        }
    }
}
