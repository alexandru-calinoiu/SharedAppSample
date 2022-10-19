package com.agilefreaks.sharedappsample.features.profile.viewer_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.agilefreaks.sharedappsample.features.profile.R
import com.agilefreaks.sharedappsample.features.profile.viewer_details.Contract

@Composable
fun Screen(
    state: Contract.State
) {
    val space24dp = dimensionResource(id = R.dimen.space_24dp)
    val space104dp = dimensionResource(id = R.dimen.space_104dp)
    val noDescriptionMessage = stringResource(id = R.string.no_description_message)

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(space104dp))
            AsyncImage(
                modifier = Modifier
                    .clip(CircleShape),
                model = state.userProfileDetails.avatarUrl,
                contentDescription = null
            )
            Text(
                text = state.userProfileDetails.bio ?: noDescriptionMessage,
                modifier = Modifier.padding(space24dp)
            )
        }
    }
}