package com.agilefreaks.sharedappsample.features.explore.repo_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.agilefreaks.sharedappsample.features.explore.R
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Repo

@Composable
fun Screen(state: Contract.State) {
    val space16dp = dimensionResource(id = R.dimen.space_16dp)

    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = space16dp)
        ) {
            if (state.isLoading) {
                item {
                    Loading(Modifier.fillParentMaxHeight())
                }
            } else {
                repoItems(
                    repos = state.repos
                )
                item {
                    Spacer(modifier = Modifier.height(space16dp))
                }
            }
        }
    }
}

fun LazyListScope.repoItems(repos: List<Repo>) {
    items(repos.size) { index ->
        Text(repos[index].name)
    }
}

@Composable
fun Loading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun ScreenPreview() {
    Screen(state = Contract.State(isLoading = true))
}
