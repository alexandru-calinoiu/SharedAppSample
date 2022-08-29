package com.agilefreaks.sharedappsample.features.explore.repository_list

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Screen(state: Contract.State) {
    Text(state.greeting)
}