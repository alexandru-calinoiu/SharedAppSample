package com.agilefreaks.sharedappsample.features.explore.repo_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.agilefreaks.sharedappsample.features.explore.R
import com.agilefreaks.sharedappsample.features.explore_shared.repo_details.RepoDetails
import com.agilefreaks.sharedappsample.features.explore_shared.repo_details.emptyRepoDetails
import com.agilefreaks.sharedappsample.ui.HandleEffects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun Screen(
    state: Contract.State,
    effects: Flow<Contract.Effect>
) {
    HandleEffects(effects) { }

    Box {
        if (state.isLoading) {
            Loading(Modifier.fillMaxSize())
        } else {
            RepoDetailScreen(state.details)
        }
    }
}

@Composable
private fun RepoDetailsHeader(state: RepoDetails) {
    val space4dp = dimensionResource(id = R.dimen.space_4dp)

    Column(modifier = Modifier.padding(space4dp)) {
        Text("Details screen")

        FieldItem("Name:", state.name)

        FieldItem("Description:", state.description)

        FieldItem("Fork Count:", state.forkCount.toString())

        FieldItem("Has Issues Enabled:", state.hasIssuesEnabled.toString())

        FieldItem("Has Project Enabled:", state.hasProjectsEnabled.toString())

        FieldItem("Has Wiki Enabled:", state.hasWikiEnabled.toString())

        FieldItem("HomePageUrl:", state.homepageUrl)
    }
}

@Composable
private fun FieldItem(fieldName: String, text: String) {
    if (text.isNotEmpty()) Text(text = "$fieldName $text")
}

@Composable
private fun RepoDetailScreen(details: RepoDetails) {
    val space4dp = dimensionResource(id = R.dimen.space_4dp)

    LazyColumn(modifier = Modifier.padding(space4dp)) {
        item {
            RepoDetailsHeader(details)
        }
        if (details.labels.isNotEmpty()) {
            item {
                Text(modifier = Modifier.padding(space4dp), text = "Labels:")
            }
            items(details.labels) { label ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.surface)
                        .padding(space4dp)
                ) {
                    Column(modifier = Modifier.padding(space4dp)) {
                        FieldItem("Name:", label.name)
                        FieldItem("Description:", label.description)
                        FieldItem("Color:", label.color)
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
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

@Composable
@Preview
fun PreviewOpen() {
    Screen(
        state = Contract.State(isLoading = true, details = emptyRepoDetails()),
        emptyFlow()
    )
}
