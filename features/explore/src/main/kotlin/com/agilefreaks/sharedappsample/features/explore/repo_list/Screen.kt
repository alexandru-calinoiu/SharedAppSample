package com.agilefreaks.sharedappsample.features.explore.repo_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.agilefreaks.sharedappsample.features.explore.R
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Repo
import com.agilefreaks.sharedappsample.ui.PagingView
import kotlinx.coroutines.flow.flowOf

@Composable
fun Screen(state: Contract.State) {
    val space16dp = dimensionResource(id = R.dimen.space_16dp)
    val list = state.repos.collectAsLazyPagingItems()

    if (list.loadState.refresh is LoadState.Loading) {
        Loading(Modifier.fillMaxSize())
    }
    PagingView(
        list = list,
        contentPadding = PaddingValues(space16dp)
    ) {
        items(list) {
            it?.let { RepoItem(it) }
        }
    }
}

@Composable
private fun RepoItem(repo: Repo) {
    val space8dp = dimensionResource(id = R.dimen.space_8dp)

    Column(modifier = Modifier.padding(vertical = space8dp)) {
        Text(repo.name)
        Text(repo.description)
        Row {
            Text(repo.primaryLanguage)
            Text(repo.lastActivity?.toString() ?: "Never")
        }
    }
}

@Composable
private fun Loading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
    Screen(
        state = Contract.State(
            repos = flowOf(
                PagingData.empty(
                    LoadStates(
                        LoadState.Loading,
                        LoadState.Loading,
                        LoadState.Loading
                    )
                )
            )
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun ItemScreenPreview() {
    val repos = listOf(
        Repo(
            name = "Repo 1",
            description = "Description",
            primaryLanguage = "Kotlin",
            lastActivity = null
        ),
        Repo(
            name = "repo2",
            description = "Description",
            primaryLanguage = "Haskell",
            lastActivity = null
        )
    )
    Screen(
        state = Contract.State(
            repos = flowOf(
                PagingData.from(repos)
            )
        )
    )
}
