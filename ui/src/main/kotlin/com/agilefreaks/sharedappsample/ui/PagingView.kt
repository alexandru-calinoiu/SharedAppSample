package com.agilefreaks.sharedappsample.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

@Composable
fun <T : Any> PagingView(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<T>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: LazyListScope.() -> Unit
) {
    if (list.loadState.refresh is LoadState.Error) {
        ErrorScreen()
    } else {
        LazyColumn(modifier = modifier, contentPadding = contentPadding) {
            content()

            list.apply {
                when {
                    loadState.append is LoadState.Loading -> item { ListLoadingView() }
                    loadState.append is LoadState.Error -> {
                        item { ListErrorView() }
                    }
                }
            }
        }
    }
}

@Composable
private fun ErrorScreen() {
    Text("Error happened!")
}

@Composable
private fun ListLoadingView() {
    Text("Loading")
}

@Composable
private fun ListErrorView() {
    Text("Something bad happened, check Logcat!")
}
