package com.agilefreaks.sharedappsample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.agilefreaks.sharedappsample.AppDestinations
import com.agilefreaks.sharedappsample.features.explore.explore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navHostController = rememberNavController()

            SampleAppTheme {
                Scaffold { innerPadding ->
                    NavHost(
                        navController = navHostController,
                        startDestination = AppDestinations.Features.explore,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        explore(navHostController)
                    }
                }
            }
        }
    }
}
