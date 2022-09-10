package com.agilefreaks.sharedappsample.features.explore.repo_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = space16dp, vertical = space16dp),
        verticalArrangement = Arrangement.spacedBy(space16dp),
        state = listState
    ) {
        if (state.isLoading) {
            item {
                Loading(Modifier.fillParentMaxHeight())
            }
        } else {
            repoItems(
                repos = state.repos
            )
        }
    }
}

private fun LazyListScope.repoItems(repos: List<Repo>) {
    items(repos) { RepoItem(it) }
}

@Composable
private fun RepoItem(repo: Repo) {
    Column {
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
    Screen(state = Contract.State(isLoading = true))
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
    Screen(state = Contract.State(repos = repos))
}
