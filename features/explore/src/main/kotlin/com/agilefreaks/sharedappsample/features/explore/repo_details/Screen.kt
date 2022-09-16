package com.agilefreaks.sharedappsample.features.explore.repo_details

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.agilefreaks.sharedappsample.ui.HandleEffects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun Screen(
    state: Contract.State,
    effects: Flow<Contract.Effect>,
    onSendEvent: (Contract.Event) -> Unit
) {
    val context = LocalContext.current

    HandleEffects(effects) { }

    Box {
        Text("Details screen")
    }
}

@Composable
@Preview
fun previewOpen() {
    Screen(state = Contract.State(isLoading = true), emptyFlow(), onSendEvent = {})
}
