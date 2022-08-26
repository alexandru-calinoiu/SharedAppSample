package com.agilefreaks.sharedappsample.feature1.landing

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Screen(state: Contract.State) {
    Text("Feature1 " + state.greeting)
}