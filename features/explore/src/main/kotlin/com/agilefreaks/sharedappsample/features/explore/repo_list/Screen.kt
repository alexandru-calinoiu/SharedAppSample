package com.agilefreaks.sharedappsample.features.explore.repo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.agilefreaks.sharedappsample.features.explore.R
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Contract
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.Repo
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.State
import com.agilefreaks.sharedappsample.ui.HandleEffects
import com.agilefreaks.sharedappsample.ui.PagingView
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

@Composable
fun Screen(
    state: State,
    effects: Flow<Contract.Effect>,
    onNavigate: (Contract.Effect.Navigation) -> Unit,
    onSendEvent: (Contract.Event) -> Unit
) {
    val space16dp = dimensionResource(id = R.dimen.space_16dp)
    val list = state.repos.collectAsLazyPagingItems()

    HandleEffects(effects) {
        when (it) {
            is Contract.Effect.Navigation.ToDetails ->
                onNavigate(Contract.Effect.Navigation.ToDetails(it.repoOwner, it.repoName))
        }
    }

    if (list.loadState.refresh is LoadState.Loading) {
        Loading(Modifier.fillMaxSize())
    } else {
        PagingView(
            list = list,
            contentPadding = PaddingValues(space16dp)
        ) {
            items(list) {
                it?.let {
                    RepoItem(it) {
                        onSendEvent(
                            Contract.Event.SelectRepo(
                                it.owner,
                                it.name
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RepoItem(repo: Repo, onClick: (Repo) -> Unit) {
    val space4dp = dimensionResource(id = R.dimen.space_4dp)

    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
            .clickable { onClick(repo) }
            .padding(space4dp)
    ) {
        Column(modifier = Modifier.padding(space4dp)) {
            Text(repo.name)
            Text(repo.description)
            Row {
                Text(repo.primaryLanguage)
                Text(repo.lastActivity?.toString() ?: "Never")
            }
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
        state = State(
            repos = flowOf(
                PagingData.empty(
                    LoadStates(
                        LoadState.Loading,
                        LoadState.Loading,
                        LoadState.Loading
                    )
                )
            )
        ),
        emptyFlow(),
        { }
    ) { }
}

@Preview(showSystemUi = true)
@Composable
fun ItemScreenPreview() {
    val repos = listOf(
        Repo(
            owner = "owner",
            name = "Repo 1",
            description = "Description",
            primaryLanguage = "Kotlin",
            lastActivity = null
        ),
        Repo(
            owner = "owner",
            name = "repo2",
            description = "Description",
            primaryLanguage = "Haskell",
            lastActivity = null
        )
    )
    Screen(
        state = State(
            repos = flowOf(
                PagingData.from(repos)
            )
        ),
        emptyFlow(),
        { }
    ) { }
}
