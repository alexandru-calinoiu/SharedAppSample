package com.agilefreaks.sharedappsample.features.profile.viewer_details

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewerDetailsModule = module {
    viewModel { ViewModel(get()) }
}